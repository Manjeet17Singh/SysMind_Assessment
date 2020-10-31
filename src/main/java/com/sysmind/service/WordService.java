package com.sysmind.service;

import com.sysmind.entity.Request;
import com.sysmind.entity.Response;
import com.sysmind.entity.WordEntityResponse;

public interface WordService {	
	public Response FindIndexes(Request request);	
	public WordEntityResponse SaveWord(String word);

}
