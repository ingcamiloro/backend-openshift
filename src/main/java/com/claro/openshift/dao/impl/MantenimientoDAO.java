package com.claro.openshift.dao.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.claro.openshift.dao.IMantenimientoDAO;
import com.claro.openshift.entity.Mantenimiento;
import com.claro.openshift.repo.IMantenimientoRepo;


@Repository
@Transactional
public class MantenimientoDAO implements IMantenimientoDAO {

    @Autowired
    private IMantenimientoRepo repo;
	

    @Override
    public Mantenimiento crear(Mantenimiento mantenimiento) {
        return repo.save(mantenimiento);
    }
    
}
