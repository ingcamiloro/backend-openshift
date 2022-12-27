package com.claro.openshift.controller;

import java.util.Date;
import java.util.HashMap;
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

import com.claro.openshift.entity.Producto;
import com.claro.openshift.model.ProductoDTO;
import com.claro.openshift.service.impl.ProductoService;



@RestController
@RequestMapping("/libro")
@CrossOrigin
public class ProductoController {
    @Autowired
	private ProductoService service;

    @GetMapping( value = "/consultar",produces = "application/json")
	public List <Producto> consultar (@RequestParam("id_categoria") int id_categoria,
									  @RequestParam("id_autor")     int id_autor,
									  @RequestParam("estado")     	boolean estado,
									  @RequestParam("titulo_libro") String titulo_libro,
									  @RequestParam("fecha_llegada_biblioteca")  Date fecha_llegada_biblioteca,
									  @RequestParam("max_PERIODO_prestam")  int max_PERIODO_prestam
									  ) {		
		Map<String,Object> mapa = new HashMap<>();
		mapa.put("id_categoria", id_categoria);
		mapa.put("id_autor", id_autor);
		mapa.put("estado", id_autor);
		mapa.put("titulo_libro", titulo_libro);
		mapa.put("fecha_llegada_biblioteca", fecha_llegada_biblioteca);
		mapa.put("max_PERIODO_prestam", max_PERIODO_prestam);	
		return service.consultar(mapa);
	}



	@RequestMapping(method = RequestMethod.GET, value = "/get",produces = "application/json")
	public Page<Producto> get (@RequestParam("pagina") int pagina, @RequestParam("tamano") int tamano) {      
		
		Page<Producto> page = service.get(pagina, tamano);
		 return page;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/crear",produces = "application/json")
	public Producto crear (@RequestBody Producto producto) {       
		 
		return service.crear(producto);
	}


}
