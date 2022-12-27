package com.claro.openshift.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claro.openshift.dao.IAutorDAO;
import com.claro.openshift.dao.ICategoriaDAO;
import com.claro.openshift.entity.Autor;
import com.claro.openshift.model.AutorDTO;
import com.claro.openshift.service.IAutorService;


@Service
public class AutorService implements IAutorService {
    @Autowired
    private IAutorDAO dao;
  

    @Override
    public AutorDTO crear(Autor autor) {
        return dao.crear(autor);
    }
    


}
