package com.sysmind.dao;

import com.sysmind.entity.WordEntityListResponse;
import com.sysmind.entity.WordEntityResponse;

public interface WordDao {
	public WordEntityResponse saveWord(String word);
	public WordEntityListResponse getWords();
}
