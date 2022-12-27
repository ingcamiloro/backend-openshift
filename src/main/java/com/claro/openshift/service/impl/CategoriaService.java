package com.claro.openshift.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.claro.openshift.dao.ICategoriaDAO;
import com.claro.openshift.entity.Categoria;
import com.claro.openshift.model.CategoriaDTO;
import com.claro.openshift.service.ICategoriaService;


@Service
public class CategoriaService implements ICategoriaService {
    @Autowired
    private ICategoriaDAO dao;

    @Override
    public Categoria consultar(int id_categoria) {     
        return dao.consultar(id_categoria);
    }

    @Override
    public CategoriaDTO crear(Categoria categoria) {
        return dao.crear(categoria);
    }

    @Override
    public Page<Categoria> get(int pagina, int tamano) {
      
        return dao.get(pagina,tamano);
    }
    


}
