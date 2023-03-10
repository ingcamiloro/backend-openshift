package com.claro.openshift.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claro.openshift.dao.IAutorDAO;
import com.claro.openshift.model.AutorDTO;
import com.claro.openshift.service.IAutorService;


@Service("autor_servicio")
public class AutorService implements IAutorService {
    @Autowired(required = true)  
    private IAutorDAO dao;
  

  


    @Override
    public List<AutorDTO> getList() {
      
        return dao.getList();
    }





    @Override
    public AutorDTO crear(AutorDTO autor) {
        return dao.crear(autor);
    }
    


}
