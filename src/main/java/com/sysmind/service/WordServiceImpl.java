package com.sysmind.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysmind.dao.WordDao;
import com.sysmind.entity.Request;
import com.sysmind.entity.Response;
import com.sysmind.entity.WordEntityResponse;

/*
 * This is service layer which contains business logic
 */

@Service
public class WordServiceImpl implements WordService{
	@Autowired
	WordDao wordDao;
	
	public Response FindIndexes(Request request)
	{
		//Initial Conditions
		Response response = new Response();
		try
		{
			if(request.Word.length()==0 || request.WordList.size()==0) {
				response.validationResult.AddError("One or more inputs a empty string", "INPUT");
				return response;
			}
				
			//Local variables
	        int wordLength = request.WordList.get(0).length(); 
	        int totalWordListLength = request.WordList.size()*wordLength; 
			String word = request.Word;
			String wordList[] = new String[request.WordList.size()];
	        HashMap<String,Integer> wordListMap = new HashMap<String,Integer>();
			List<Integer> result = new ArrayList<Integer>();			
			int index = 0;
			
			for (String val : request.WordList) {
				if(val.length() != wordLength)
				{
					response.validationResult.AddError("Words are of unequal size", "INPUT");
					return response;
				}
				wordList[index++] = val;
			}
	        
			
			//main logic        
	        for(int i=0; i<wordList.length; i++){
	        	wordListMap.put(wordList[i], wordListMap.getOrDefault(wordList[i], 0) + 1);
	        }
	        
	        
	        index = 0;
	        while(index <= word.length() - totalWordListLength){  
		        String sub = word.substring(index, index + totalWordListLength);
		        HashMap<String,Integer> subStringMap = new HashMap<String,Integer>();
		        int k = 0;
		        int n = 0;
		        
		        while(k<wordList.length){
		          String temp = sub.substring(n, n + wordLength);
		          subStringMap.put(temp, subStringMap.getOrDefault(temp,0) + 1);
		          n = n + wordLength; 
		          k++;  
		        }
		        if(wordListMap.equals(subStringMap))
		        	result.add(index);
		        index++;  
	        }
	        response.setIndexes(result);
		}catch(Exception ex)
		{
			response.validationResult.AddError("ERROR : An error occured" + ex.getMessage(), "EXCEPTION");
		}
    	return response;
	}
	
	public WordEntityResponse SaveWord(String word)
	{
		WordEntityResponse response = new WordEntityResponse();
		try
		{
			response = wordDao.SaveWord(word);
		}catch(Exception ex)
		{
			response.setResult(false);
			response.validationResult.AddError("ERROR : An error occured" + ex.getMessage(), "EXCEPTION");
		}
    	return response;
	}

}
