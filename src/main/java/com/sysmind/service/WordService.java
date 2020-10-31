package com.sysmind.service;

import com.sysmind.entity.Request;
import com.sysmind.entity.Response;
import com.sysmind.entity.WordEntityListResponse;
import com.sysmind.entity.WordEntityResponse;

public interface WordService {	
	public Response findIndexes(Request request);	
	public WordEntityResponse saveWord(String word);
	public WordEntityListResponse getWords();

}
