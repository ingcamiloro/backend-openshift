package com.claro.openshift.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claro.openshift.dao.IProductoDAO;
import com.claro.openshift.model.ProductoDTO;
import com.claro.openshift.service.IProductoService;

@Service
public class ProductoService implements IProductoService {
	@Autowired
	private IProductoDAO dao;

    @Override
    public List<ProductoDTO> consultar(ProductoDTO libro) {    
        return dao.consultar(libro);
    }

    @Override
    public Map<String, Object> get(int pagina, int tamano) {      
        return dao.get(pagina, tamano);
    }

    @Override
    public ProductoDTO crear(ProductoDTO producto) {
        
        return dao.crear(producto);
    }

    
    
}
