package com.claro.openshift.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.claro.openshift.model.CategoriaDTO;

public interface ICategoriaService {
    public CategoriaDTO crear(CategoriaDTO autor) ;
    public List<CategoriaDTO> getList();
}
