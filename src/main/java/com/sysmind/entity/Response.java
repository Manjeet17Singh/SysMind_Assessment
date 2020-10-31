package com.sysmind.entity;

import java.util.List;

import com.sysmind.validation.ValidationResult;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Response extends ValidationResult{
	List<Integer> Indexes;

}
