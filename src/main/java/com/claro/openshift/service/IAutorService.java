package com.claro.openshift.service;

import java.util.List;
import java.util.Map;

import com.claro.openshift.model.AutorDTO;

public interface IAutorService {
    public AutorDTO crear(AutorDTO autor);
    public List<AutorDTO> getList();
}
