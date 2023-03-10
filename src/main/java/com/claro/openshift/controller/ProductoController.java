package com.claro.openshift.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.claro.openshift.service.IProductoService;


@RestController
@RequestMapping("/libro")
@CrossOrigin
public class ProductoController {
    @Autowired
	private IProductoService service;



    @GetMapping( value = "/consultar",produces = "application/json")
	public ResponseEntity<Map<String,Object>> consultar (
		                              @RequestParam("id_categoria") int id_categoria,
									  @RequestParam("id_autor")     int id_autor,
									  @RequestParam(value="estado",required=false)     	boolean estado,
									  @RequestParam(value="titulo_libro",required=false) String titulo_libro,
									  @RequestParam(value="fecha_llegada_biblioteca",required=false)  Date fecha_llegada_biblioteca,
									  @RequestParam(value="max_PERIODO_prestam",required=false)  int max_PERIODO_prestam
									  ) {		
		Map<String,Object> mapa = new HashMap<>();
		mapa.put("id_categoria", id_categoria);
		mapa.put("id_autor", id_autor);
		mapa.put("estado", id_autor);
		mapa.put("titulo_libro", titulo_libro);
		mapa.put("fecha_llegada_biblioteca", fecha_llegada_biblioteca);
		mapa.put("max_PERIODO_prestam", max_PERIODO_prestam);	
		return new ResponseEntity<Map<String,Object>>(service.getFiltro(mapa),HttpStatus.OK);
	}




	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, value = "/getAll",produces = "application/json")
	public Map<String,Object> getList () {      
		
		 return service.getList();
	}


}
