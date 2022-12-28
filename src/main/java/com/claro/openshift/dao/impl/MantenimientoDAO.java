package com.claro.openshift.dao.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.claro.openshift.dao.IMantenimientoDAO;
import com.claro.openshift.entity.Mantenimiento;
import com.claro.openshift.repo.IMantenimientoRepo;

import org.springframework.stereotype.Service;
@Service
public class MantenimientoDAO implements IMantenimientoDAO {

    @Autowired
    private IMantenimientoRepo repo;
	

    @Override
    public Mantenimiento crear(Mantenimiento mantenimiento) {
        return repo.save(mantenimiento);
    }

    @Override
    public Page<Mantenimiento> get(int pagina, int tamano){    

        Pageable pageable =  PageRequest.of(pagina, tamano,Sort.by("id"));
        return repo.findAll(pageable); 

    }
    
}
