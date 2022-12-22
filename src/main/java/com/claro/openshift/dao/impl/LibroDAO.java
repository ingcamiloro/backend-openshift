package com.claro.openshift.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.claro.openshift.dao.ILibroDAO;
import com.claro.openshift.model.AutorDTO;
import com.claro.openshift.model.CategoriaDTO;
import com.claro.openshift.model.LibroDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
@Transactional
public class LibroDAO implements ILibroDAO {

    private static final Logger logger = LoggerFactory.getLogger(LibroDAO.class);
    

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT-5")
	private Date date = new Date();

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private JdbcTemplate getJdbcTemplate(){
		return jdbcTemplate;
	}

    @Override
    public List<LibroDTO> consultar(LibroDTO libro) {
        List<LibroDTO> lista = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lista.add(new LibroDTO(i, ""+i, new CategoriaDTO(i, ""+i), new AutorDTO(i,""+i), false, date, i));
        }
        return lista;
    }

}
