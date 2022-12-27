package com.claro.openshift.dao;

import java.util.Map;

import com.claro.openshift.entity.Autor;

public interface  IAutorDAO {
    public Map<String,Object> get(int pagina, int tamano);    
    public Autor crear(Autor autor);
    public Autor consultar(int id_autor);
  
}
