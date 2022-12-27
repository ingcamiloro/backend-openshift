package com.claro.openshift.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.claro.openshift.entity.Mantenimiento;
import com.claro.openshift.service.IMantenimientoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/mantenimiento")
@CrossOrigin
public class MantenimientoController {
    
    @Autowired
	private IMantenimientoService service;

    @RequestMapping(method = RequestMethod.POST, value = "/crear",produces = "application/json")
	public Mantenimiento crear (@RequestBody Mantenimiento mantenimiento) {      
		 
		return service.crear(mantenimiento);
	}


    @RequestMapping(method = RequestMethod.GET, value = "/get",produces = "application/json")
	public Page<Mantenimiento> get (@RequestParam("pagina") int pagina, @RequestParam("tamano") int tamano) {      
		
		 return service.get(pagina, tamano);
	}
}
