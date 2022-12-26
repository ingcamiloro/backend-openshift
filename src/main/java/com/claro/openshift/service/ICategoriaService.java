package com.claro.openshift.service;

import com.claro.openshift.model.CategoriaDTO;

public interface ICategoriaService {
    public void consultar(CategoriaDTO categoria);
    public CategoriaDTO crear(CategoriaDTO categoria);
}
