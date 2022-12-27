package com.claro.openshift.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.claro.openshift.entity.Producto;
import com.claro.openshift.model.ProductoDTO;
import com.claro.openshift.service.impl.ProductoService;



@RestController
@RequestMapping("/producto")
@CrossOrigin
public class ProductoController {
    @Autowired
	private ProductoService service;

    @RequestMapping(method = RequestMethod.GET, value = "/consutar",produces = "application/json")
	public List<Producto> getConsultar () {       
		 
		return service.consultar();
	}



	@RequestMapping(method = RequestMethod.GET, value = "/get",produces = "application/json")
	public Page<Producto> get (@RequestParam("pagina") int pagina, @RequestParam("tamano") int tamano) {      
		
		Page<Producto> page = service.get(pagina, tamano);
		 return page;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/crear",produces = "application/json")
	public ProductoDTO crear (@RequestBody Producto producto) {       
		 
		return service.crear(producto);
	}


}
