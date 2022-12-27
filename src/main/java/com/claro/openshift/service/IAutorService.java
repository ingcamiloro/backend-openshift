package com.claro.openshift.service;

import com.claro.openshift.entity.Autor;
import com.claro.openshift.model.AutorDTO;

public interface IAutorService {
    public AutorDTO crear(Autor categoria);
}
