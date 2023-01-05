package com.claro.openshift.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.claro.openshift.model.AutorDTO;
import com.claro.openshift.service.IAutorService;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/autor")
@CrossOrigin
public class AutorController {

	@Autowired
	private Environment env;


    @Autowired(required = true)
	private IAutorService service;  


	@RequestMapping(method = RequestMethod.GET, value = "/getAll",produces = "application/json")
	public ResponseEntity<List<AutorDTO>> getList () {      
		
		 return new ResponseEntity<List<AutorDTO>>(service.getList(),HttpStatus.OK);
	}
	@RequestMapping(method = RequestMethod.POST, value = "/crear",produces = "application/json")
	public ResponseEntity<AutorDTO> crear (@RequestBody(required = true)AutorDTO autor) {  
		return new ResponseEntity<AutorDTO>(service.crear(autor),HttpStatus.OK);
	}



}
