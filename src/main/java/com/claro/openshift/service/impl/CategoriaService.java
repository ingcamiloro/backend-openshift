package com.claro.openshift.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.claro.openshift.dao.ICategoriaDAO;
import com.claro.openshift.model.CategoriaDTO;
import com.claro.openshift.service.ICategoriaService;


@Service
public class CategoriaService implements ICategoriaService {
    @Autowired
    private ICategoriaDAO dao;

  
    @Override
    public List<CategoriaDTO> getList() {
        return dao.getList();
    }
    


}
