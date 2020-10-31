package com.sysmind.validation;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ValidationResult { 
	public ValidationResult() {
		Errors = new ArrayList<String>();
	}
	private String ErrorType = "None";
    private List<String> Errors;    
    private boolean IsValid = true;
    public void AddError(String error, String errorType)
    {
    	this.ErrorType = errorType;
    	this.IsValid = false;
    	this.Errors.add(error);
    }
}
