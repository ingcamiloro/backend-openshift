package com.claro.openshift.dao;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import com.claro.openshift.model.CategoriaDTO;

@Repository
public interface  ICategoriaDAO{

  
    public List<CategoriaDTO> getList();
}
