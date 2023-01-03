package com.claro.openshift.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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


	@RequestMapping(method = RequestMethod.GET, value = "/get",produces = "application/json")
	public Page<Categoria> get (@RequestParam("pagina") int pagina, @RequestParam("tamano") int tamano) {      
		
		 return service.get(pagina, tamano);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getAll",produces = "application/json")
	public List<CategoriaDTO> getList () {      
		
		 return service.getList();
	}

	@GetMapping( value = "/consultar",produces = "application/json")
	public Categoria consultar (@RequestParam("id_categoria") int id_categoria ) {		
	
		return service.consultar(id_categoria);
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, value = "/crear",produces = "application/json")
	public CategoriaDTO crear (@RequestBody Categoria categoria) {   
		 
		 return service.crear(categoria);
	}

}
