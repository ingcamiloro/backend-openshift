package com.claro.openshift.service;

import java.util.List;
import com.claro.openshift.model.PropiedadesDTO;

public interface IPropiedadService {
    public List<PropiedadesDTO> consultarPropiedades(PropiedadesDTO propierdad);
}
