package com.claro.openshift.dao;

import java.util.List;

import com.claro.openshift.model.PropiedadesDTO;

public interface  IPropiedadDAO {
    public List <PropiedadesDTO> consultarPropiedades(PropiedadesDTO propierdad);
  
}
