package com.claro.openshift.service;

import java.util.List;

import com.claro.openshift.model.LibroDTO;

public interface ILibroService {
    public List<LibroDTO> consultar(LibroDTO libro);
}
