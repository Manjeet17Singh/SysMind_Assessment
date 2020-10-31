package com.sysmind.entity;

import java.util.ArrayList;
import java.util.List;

import com.sysmind.validation.ValidationResult;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class WordEntityListResponse {
	public WordEntityListResponse() {
		validationResult = new ValidationResult();
		result = new ArrayList<WordEntity>();
	}
	public ValidationResult validationResult;
	private List<WordEntity> result;


}
