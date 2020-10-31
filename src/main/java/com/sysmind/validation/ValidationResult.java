package com.sysmind.validation;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ValidationResult { 
	private String None ="None";
	
	public String ErrorType = None;
    public List<String> Errors;    
    public boolean IsValid = (Errors == null || Errors.size() == 0);
}
