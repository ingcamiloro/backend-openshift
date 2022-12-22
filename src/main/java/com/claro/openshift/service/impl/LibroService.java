package com.claro.openshift.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claro.openshift.dao.ILibroDAO;
import com.claro.openshift.model.LibroDTO;
import com.claro.openshift.service.ILibroService;

@Service
public class LibroService implements ILibroService {
	@Autowired
	private ILibroDAO dao;

    @Override
    public List<LibroDTO> consultar(LibroDTO libro) {    
        return dao.consultar(libro);
    }
    
}
