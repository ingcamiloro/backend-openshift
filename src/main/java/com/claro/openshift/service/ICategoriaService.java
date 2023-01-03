package com.claro.openshift.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.claro.openshift.entity.Categoria;
import com.claro.openshift.model.CategoriaDTO;

public interface ICategoriaService {
    public Categoria consultar(int id_categoria);
    public CategoriaDTO crear(Categoria categoria);
    public Page<Categoria> get(int pagina, int tamano);
    public List<CategoriaDTO> getList();
}
