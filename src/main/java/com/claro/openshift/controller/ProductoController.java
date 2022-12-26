package com.claro.openshift.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.claro.openshift.entity.Categoria;
import com.claro.openshift.model.ProductoDTO;
import com.claro.openshift.service.impl.ProductoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/producto")
@CrossOrigin
public class ProductoController {
    @Autowired
	private ProductoService service;

    @RequestMapping(method = RequestMethod.GET, value = "/consutar",produces = "application/json")
	public List<ProductoDTO> getConsultar (@RequestBody ProductoDTO libro) {       
		 
		return service.consultar(libro);
	}



	@RequestMapping(method = RequestMethod.GET, value = "/get",produces = "application/json")
	public Map<String, Object> get (@RequestParam("pagina") int pagina, @RequestParam("tamano") int tamano) {      
		
		 
		 return service.get(pagina, tamano);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/crear",produces = "application/json")
	public ProductoDTO crear (@RequestBody ProductoDTO producto) {       
		 
		return service.crear(producto);
	}


}
