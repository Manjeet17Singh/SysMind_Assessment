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

import com.sysmind.entity.WordEntityResponse;
import com.sysmind.service.WordService;

@CrossOrigin
@RestController()
@RequestMapping("/api")
public class WordDbController {

	@Autowired
	WordService wordService;
	
	@CrossOrigin
    @RequestMapping( produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/saveWordDb")
    public ResponseEntity<WordEntityResponse> findWord(@RequestBody String word) {
		WordEntityResponse wordEntityResponse = new WordEntityResponse();
		wordEntityResponse = wordService.SaveWord(word);
		return new ResponseEntity<>(wordEntityResponse, HttpStatus.OK);
	}
	

}
