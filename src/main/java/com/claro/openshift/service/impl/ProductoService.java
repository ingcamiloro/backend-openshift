package com.claro.openshift.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.claro.openshift.dao.IProductoDAO;
import com.claro.openshift.entity.Producto;
import com.claro.openshift.model.ProductoDTO;
import com.claro.openshift.service.IProductoService;

@Service
public class ProductoService implements IProductoService {
	@Autowired
	private IProductoDAO dao;

    @Override
    public List<Producto> consultar() {    
        return dao.consultar();
    }

    @Override
    public Page<Producto> get(int pagina, int tamano) {      
        return dao.get(pagina, tamano);
    }

    @Override
    public ProductoDTO crear(Producto producto) {
        
        return dao.crear(producto);
    }

    
    
}
