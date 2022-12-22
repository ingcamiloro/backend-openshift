package com.claro.openshift.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.claro.openshift.model.LibroDTO;
import com.claro.openshift.service.impl.LibroService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/libro")
@CrossOrigin
public class LibroController {
    @Autowired
	private LibroService service;

    @RequestMapping(method = RequestMethod.GET, value = "/consutar",produces = "application/json")
	public List<LibroDTO> getConsultar (@RequestBody LibroDTO libro) {        
		return service.consultar(libro);
	}

}
