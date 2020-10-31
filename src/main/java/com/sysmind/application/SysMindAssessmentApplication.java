package com.sysmind.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.sysmind.dao.WordDao;
import com.sysmind.restcontroller.BaseController;
import com.sysmind.service.WordService;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = {BaseController.class, WordService.class, WordDao.class})
public class SysMindAssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SysMindAssessmentApplication.class, args);
	}

}
