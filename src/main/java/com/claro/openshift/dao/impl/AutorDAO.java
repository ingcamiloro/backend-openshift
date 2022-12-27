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
    public AutorDTO crear(Autor autor) {
        Autor res = repo.save(autor);
        if(res != null){
            return new AutorDTO(res.getId(), res.getNombre());
        }
        return null;
    }
    


}
