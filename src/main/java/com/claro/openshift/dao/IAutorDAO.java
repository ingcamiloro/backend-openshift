package com.claro.openshift.dao;

import java.util.List;
import java.util.Map;

import com.claro.openshift.entity.Autor;
import com.claro.openshift.model.AutorDTO;

public interface  IAutorDAO {
    public Map<String,Object> get(int pagina, int tamano);    
    public Map<String,Object> crear(Autor autor);
    public Autor consultar(int id_autor);
    public List<AutorDTO> getList();
}
