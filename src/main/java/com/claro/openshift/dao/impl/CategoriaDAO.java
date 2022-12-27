package com.claro.openshift.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.claro.openshift.dao.ICategoriaDAO;
import com.claro.openshift.entity.Categoria;
import com.claro.openshift.model.CategoriaDTO;
import com.claro.openshift.repo.ICategoriaRepo;
import com.claro.openshift.repo.IProductoRepo;

@Repository
@Transactional
public class CategoriaDAO implements ICategoriaDAO {
    @Autowired
    private ICategoriaRepo repo;
  
    @Override
    public void consultar(CategoriaDTO categoria) {

    } 

    @Override
    public CategoriaDTO crear(Categoria categoria) {

        Categoria res = repo.save(categoria);
        return new CategoriaDTO(res.getId(),res.getNombre());
      
    }
    @Override
     public Page<Categoria> get(int pagina, int tamano){  

        Pageable pageable =  PageRequest.of(pagina, tamano,Sort.by("id"));
        return repo.findAll(pageable); 

    }

}
