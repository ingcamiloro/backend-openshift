package com.claro.openshift.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.claro.openshift.dao.IProductoDAO;
import com.claro.openshift.dao.IPropiedadDAO;
import com.claro.openshift.entity.Producto;
import com.claro.openshift.model.ProductoDTO;
import com.claro.openshift.model.PropiedadesDTO;
import com.claro.openshift.service.IProductoService;
import com.claro.openshift.service.IPropiedadService;

@Service
public class PropiedadService implements IPropiedadService {
	@Autowired
	private IPropiedadDAO dao;

    @Override
    public List<PropiedadesDTO> consultarPropiedades(PropiedadesDTO propierdad) {
     
        return dao.consultarPropiedades(propierdad);
    }

    
    
}
