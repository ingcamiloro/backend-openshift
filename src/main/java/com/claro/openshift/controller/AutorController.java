package com.claro.openshift.controller;


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

import com.claro.openshift.entity.Autor;
import com.claro.openshift.service.IAutorService;


@RestController
@RequestMapping("/autor")
@CrossOrigin
public class AutorController {

    @Autowired(required = true)
	private IAutorService service;  

	@RequestMapping(method = RequestMethod.POST, value = "/crear",produces = "application/json")
	public Map<String,Object> crear (@RequestBody Autor autor) {       
		 
		return service.crear(autor);
	}

	@GetMapping( value = "/consultar",produces = "application/json")
	public Autor consultar (@RequestParam("id_autor") int id_autor ) {		
	
		return service.consultar(id_autor);
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, value = "/getAll",produces = "application/json")
	public Map<String,Object> getList () {      
		
		 return service.getList();
	}


}
