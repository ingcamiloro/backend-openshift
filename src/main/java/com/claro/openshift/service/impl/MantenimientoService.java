package com.claro.openshift.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.claro.openshift.dao.IMantenimientoDAO;
import com.claro.openshift.service.IMantenimientoService;

@Service
public class MantenimientoService implements IMantenimientoService{
	@Autowired
	private IMantenimientoDAO dao;

    
    
}
