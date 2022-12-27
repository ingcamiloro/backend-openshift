package com.claro.openshift.service;

import org.springframework.data.domain.Page;

import com.claro.openshift.entity.Categoria;
import com.claro.openshift.model.CategoriaDTO;

public interface ICategoriaService {
    public void consultar(CategoriaDTO categoria);
    public CategoriaDTO crear(Categoria categoria);
    public Page<Categoria> get(int pagina, int tamano);
}
