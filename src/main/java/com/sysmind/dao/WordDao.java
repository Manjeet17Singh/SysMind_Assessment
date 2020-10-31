package com.sysmind.dao;

import com.sysmind.entity.WordEntityResponse;

public interface WordDao {
	public WordEntityResponse SaveWord(String word);
}
