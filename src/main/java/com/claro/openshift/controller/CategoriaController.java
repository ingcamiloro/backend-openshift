package com.claro.openshift.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.claro.openshift.model.CategoriaDTO;
import com.claro.openshift.service.ICategoriaService;
@RestController
@RequestMapping("/categoria")
@CrossOrigin
public class CategoriaController {
    @Autowired
	private ICategoriaService service;



	@RequestMapping(method = RequestMethod.GET, value = "/getAll",produces = "application/json")
	public ResponseEntity<List<CategoriaDTO>> getList () {      
		
		 return new ResponseEntity<List<CategoriaDTO>>(service.getList(),HttpStatus.OK);
	}


}
