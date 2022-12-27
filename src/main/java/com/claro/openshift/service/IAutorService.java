package com.claro.openshift.service;

import com.claro.openshift.entity.Autor;
import com.claro.openshift.model.AutorDTO;

public interface IAutorService {
    public Autor consultar(int id_autor);
    public Autor crear(Autor categoria);
}
