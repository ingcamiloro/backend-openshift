package com.claro.openshift.dao.impl;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.claro.openshift.dao.IAutorDAO;
import com.claro.openshift.entity.Autor;
import com.claro.openshift.model.AutorDTO;
import com.claro.openshift.model.ProductoDTO;
import com.claro.openshift.repo.IAutorRepo;


@Repository
@Transactional
public class AutorDAO implements IAutorDAO{
    
    @Autowired
    private IAutorRepo repo;
    
    @Override
    public Map<String, Object> get(int pagina, int tamano) {
      
        return null;
    }

    @Override
    public Autor crear(Autor autor) {
        return repo.save(autor);
    }

    @Override
    public Autor consultar(int id_autor) {
     
        return repo.buscarAutorID(id_autor);
    }
    


}
