package com.sysmind.restcontroller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sysmind.entity.Request;
import com.sysmind.entity.Response;
import com.sysmind.service.WordService;


/*
 * Request will be redirected to this controller 
 */

@CrossOrigin
@RestController()
@RequestMapping("/api")
public class WordController {
	@Autowired
	WordService wordService;
	
	@CrossOrigin
    @RequestMapping( produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/findWord")
    public ResponseEntity<Response> findWord(@RequestBody Request request) {
		Response response = new Response();
		if(request == null || request.Word == null || request.WordList == null)
		{
			response.Errors.add("Request cannot be null");
		}
		response = wordService.FindIndexes(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}


}
