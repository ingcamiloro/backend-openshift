package com.claro.openshift.dao;

import java.util.List;

import com.claro.openshift.model.LibroDTO;

public interface  ILibroDAO {
    public List<LibroDTO> consultar(LibroDTO libro);
}
