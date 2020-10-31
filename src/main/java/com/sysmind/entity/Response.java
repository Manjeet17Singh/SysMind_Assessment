package com.sysmind.entity;

import java.util.List;

import com.sysmind.validation.ValidationResult;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Response{
	public Response() {
		validationResult = new ValidationResult();
	}
	public ValidationResult validationResult;
	private List<Integer> Indexes;
}
