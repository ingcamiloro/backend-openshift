package com.claro.openshift.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.claro.openshift.entity.Autor;
import com.claro.openshift.model.AutorDTO;
import com.claro.openshift.service.impl.AutorService;


@RestController
@RequestMapping("/autor")
@CrossOrigin
public class AutorController {
    @Autowired
	private AutorService service;  

	@RequestMapping(method = RequestMethod.POST, value = "/crear",produces = "application/json")
	public AutorDTO crear (@RequestBody Autor autor) {       
		 
		return service.crear(autor);
	}


}
