package com.sysmind.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sysmind.entity.Request;
import com.sysmind.entity.Response;

/*
 * This is service layer which contains business logic
 */

@Service
public class WordServiceImpl implements WordService{
	public Response FindIndexes(Request request)
	{
		//Initial Conditions
		Response response = new Response();
		if(request.Word.length()==0 || request.WordList.size()==0) {
			response.setIndexes(new ArrayList<>());
			return response;
		}
			
		//Local variables
		String word = request.Word;
		String wordList[] = new String[request.WordList.size()];
		List<Integer> result = new ArrayList<Integer>();			
		int index=0;
		
		for (String string : request.WordList) {
			wordList[index++] = string;
		}
        
		
		//main logic
        HashMap<String,Integer> wordListMap = new HashMap<String,Integer>();        
        for(int i=0; i<wordList.length; i++){
        	wordListMap.put(wordList[i], wordListMap.getOrDefault(wordList[i], 0) + 1);
        }
        
        int totalWordListLength = wordList.length*wordList[0].length(); 
        int wordLength = wordList[0].length(); 
        
        index = 0;
        while(index <= word.length() - totalWordListLength){  
	        String sub = word.substring(index, index + totalWordListLength);
	        HashMap<String,Integer> subStringMap = new HashMap<String,Integer>();
	        int k = 0;
	        int n = 0;
	        
	        while(k<wordList.length){
	          String temp = sub.substring(n, n+wordLength);
	          subStringMap.put(temp, subStringMap.getOrDefault(temp,0) + 1);
	          n = n + wordLength; 
	          k++;  
	        }
	        if(wordListMap.equals(subStringMap))
	        	result.add(index);
	        index++;  
        }
        response.setIndexes(result);;
    	return response;
	}

}
