package com.claro.openshift.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.claro.openshift.dao.IAutorDAO;
import com.claro.openshift.dao.ICategoriaDAO;
import com.claro.openshift.entity.Autor;
import com.claro.openshift.model.AutorDTO;
import com.claro.openshift.service.IAutorService;


@Service("autor_servicio")
public class AutorService implements IAutorService {
    @Autowired
    @Qualifier("autor_dao")
    private IAutorDAO dao;
  

    @Override
    public Autor crear(Autor autor) {
        return dao.crear(autor);
    }


    @Override
    public Autor consultar(int id_autor) {
        return dao.consultar(id_autor);
    }
    


}
