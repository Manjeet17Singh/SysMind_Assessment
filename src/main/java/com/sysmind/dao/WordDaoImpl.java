package com.sysmind.dao;

import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;

import com.sysmind.entity.WordEntity;
import com.sysmind.entity.WordEntityResponse;

/*
 * This is data access layer
 */

@Repository
public class WordDaoImpl implements WordDao{
	static SessionFactory sessionFactoryObj;
	
	private static SessionFactory buildSessionFactory() {		
		try {			
			Configuration configObj = new Configuration();
	        configObj.configure("hibernate.cfg.xml");
	        configObj.addAnnotatedClass(com.sysmind.entity.WordEntity.class);
	        configObj.configure();
	        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build(); 
	        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
			}catch(SessionException sessionException){
				sessionException.printStackTrace();
		}       
        return sessionFactoryObj;
	}
	
	
	public WordEntityResponse SaveWord(String word)
	{
		WordEntityResponse response = new WordEntityResponse();
		Session sessionObj = null;
        try {
           sessionObj = buildSessionFactory().openSession();           
           sessionObj.beginTransaction();    
           WordEntity wordEntity = new WordEntity();
           wordEntity.setWord(word);
           sessionObj.save(wordEntity);        
           sessionObj.getTransaction().commit(); 
           response.setResult(true);
           
        }catch(NullPointerException nullPointerException){
        	response.validationResult.AddError(nullPointerException.getMessage(), "DB ERROR");
        	
        }catch(Exception sqlException){        	
           if(sessionObj!=null && sessionObj.getTransaction()!=null) {
               sessionObj.getTransaction().rollback();
           }
           response.validationResult .AddError(sqlException.getMessage(), "DB ERROR");          
        }
        finally {
           if(sessionObj != null) {
               sessionObj.close();
           }
       }  
       return response;		
	}

}
