package com.claro.openshift.dao;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import com.claro.openshift.entity.Categoria;
import com.claro.openshift.model.CategoriaDTO;

@Repository
public interface  ICategoriaDAO{
    public Categoria consultar(int id_categoria);
    public CategoriaDTO crear(Categoria categoria);

    public Page<Categoria> get(int pagina, int tamano);     
    public Map<String,Object> getList();
}
