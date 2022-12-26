package com.claro.openshift.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claro.openshift.dao.ICategoriaDAO;
import com.claro.openshift.model.CategoriaDTO;
import com.claro.openshift.service.ICategoriaService;


@Service
public class CategoriaService implements ICategoriaService {
    @Autowired
    private ICategoriaDAO dao;

    @Override
    public void consultar(CategoriaDTO categoria) {     
        
    }

    @Override
    public CategoriaDTO crear(CategoriaDTO categoria) {
        return dao.crear(categoria);
    }
    


}
