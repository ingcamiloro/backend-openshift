package com.claro.openshift.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.claro.openshift.dao.IProductoDAO;
import com.claro.openshift.model.ProductoDTO;
import com.claro.openshift.service.IProductoService;

@Service
public class ProductoService implements IProductoService {
	@Autowired
	private IProductoDAO dao;

    @Override
    public Map<String, Object> getList() {
        return dao.getList();
    }

    @Override
    public Map<String, Object> getFiltro(Map<String, Object> inParametros) {
       
        return dao.getFiltro (inParametros);
    }

    
    
}
