package com.claro.openshift.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.claro.openshift.entity.Categoria;
import com.claro.openshift.model.CategoriaDTO;
import com.claro.openshift.service.ICategoriaService;
@RestController
@RequestMapping("/categoria")
@CrossOrigin
public class CategoriaController {
    @Autowired
	private ICategoriaService service;


	@RequestMapping(method = RequestMethod.POST, value = "/crear",produces = "application/json")
	public CategoriaDTO crear (@RequestBody Categoria categoria) {   
		 
		 return service.crear(categoria);
	}

}
