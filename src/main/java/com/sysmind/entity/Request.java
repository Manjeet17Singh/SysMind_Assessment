package com.sysmind.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Request {
	public String word;
	public List<String> wordList;
}
