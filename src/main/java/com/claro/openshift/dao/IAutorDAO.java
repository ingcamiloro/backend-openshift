package com.claro.openshift.dao;

import java.util.List;
import java.util.Map;

import com.claro.openshift.model.AutorDTO;

public interface  IAutorDAO {
    public AutorDTO crear(AutorDTO autor) ;  
    public List<AutorDTO> getList();
}
