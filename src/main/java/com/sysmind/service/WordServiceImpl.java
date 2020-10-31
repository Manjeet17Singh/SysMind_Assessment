package com.sysmind.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysmind.dao.WordDao;
import com.sysmind.entity.Request;
import com.sysmind.entity.Response;
import com.sysmind.entity.WordEntityListResponse;
import com.sysmind.entity.WordEntityResponse;

/*
 * This is service layer which contains business logic
 */

@Service
public class WordServiceImpl implements WordService{
	@Autowired
	WordDao wordDao;
	
	public Response findIndexes(Request request)
	{
		//Initial Conditions
		Response response = new Response();
		try
		{
			if(request.word.length()==0 || request.wordList.size()==0) {
				response.validationResult.addError("One or more inputs a empty string", "INPUT");
				return response;
			}
				
			//Local variables
	        int wordLength = request.wordList.get(0).length(); 
	        int totalWordListLength = request.wordList.size()*wordLength; 
			String word = request.word;
			String wordList[] = new String[request.wordList.size()];
	        HashMap<String,Integer> wordListMap = new HashMap<String,Integer>();
			List<Integer> result = new ArrayList<Integer>();			
			int index = 0;
			
			for (String val : request.wordList) {
				if(val.length() != wordLength)
				{
					response.validationResult.addError("Words are of unequal size", "INPUT");
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
			response.validationResult.addError("ERROR : An error occured" + ex.getMessage(), "EXCEPTION");
		}
    	return response;
	}
	
	
	
	public WordEntityResponse saveWord(String word)
	{
		WordEntityResponse response = new WordEntityResponse();
		try
		{
			response = wordDao.saveWord(word);
		}catch(Exception ex)
		{
			response.setResult(false);
			response.validationResult.addError("ERROR : An error occured" + ex.getMessage(), "EXCEPTION");
		}
    	return response;
	}
	
	
	
	public WordEntityListResponse getWords()
	{
		WordEntityListResponse response = new WordEntityListResponse();
		try
		{
			response = wordDao.getWords();
		}catch(Exception ex)
		{
			response.validationResult.addError("ERROR : An error occured" + ex.getMessage(), "EXCEPTION");
		}
    	return response;
	}

}
