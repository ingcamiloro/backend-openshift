package com.claro.openshift.dao;

import java.util.Map;

import com.claro.openshift.entity.Autor;
import com.claro.openshift.model.AutorDTO;
import com.claro.openshift.model.ProductoDTO;

public interface  IAutorDAO {
    public Map<String,Object> get(int pagina, int tamano);    
    public AutorDTO crear(Autor autor);
  
}
