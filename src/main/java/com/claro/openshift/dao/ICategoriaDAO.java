package com.claro.openshift.dao;
import org.springframework.stereotype.Repository;

import com.claro.openshift.entity.Categoria;
import com.claro.openshift.model.CategoriaDTO;

@Repository
public interface  ICategoriaDAO{
    public void consultar(CategoriaDTO categoria);
    public CategoriaDTO crear(Categoria categoria);
}
