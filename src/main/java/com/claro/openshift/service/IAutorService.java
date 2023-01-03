package com.claro.openshift.service;

import java.util.List;
import java.util.Map;

import com.claro.openshift.entity.Autor;
import com.claro.openshift.model.AutorDTO;

public interface IAutorService {
    public Autor consultar(int id_autor);
    public Map<String,Object> crear(Autor categoria);
    public List<AutorDTO> getList();
}
