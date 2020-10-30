package com.sysmind.restcontroller;

import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sysmind.service.WordService;

/*
 * This is base controller 
 */

@CrossOrigin
@RestController()
@RequestMapping("/api")
public class BaseController {
	
	@Autowired
	WordService wordService;
	
	@CrossOrigin
    @RequestMapping( produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/findWord")
    public ResponseEntity<Object> findWord() {
		 return new ResponseEntity<>("Hello", HttpStatus.OK);
	}

}
