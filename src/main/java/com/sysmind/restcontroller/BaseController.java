package com.sysmind.restcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.sysmind.entity.Request;
import com.sysmind.entity.Response;
import com.sysmind.service.WordService;

/*
 * This is base controller to redirect to word controller
 */

@CrossOrigin
@RestController()
@RequestMapping("/api")
public class BaseController {
	
	@CrossOrigin
    @RequestMapping( produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/findWordIndex")
    public ModelAndView findWord(HttpServletRequest request) {
		request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
        return new ModelAndView("redirect:/api/findWord");		
	}

}
