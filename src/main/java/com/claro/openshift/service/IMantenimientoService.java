package com.claro.openshift.service;

import org.springframework.data.domain.Page;

import com.claro.openshift.entity.Mantenimiento;

public interface IMantenimientoService {
    public Mantenimiento crear(Mantenimiento mantenimiento);  
    
    public Page<Mantenimiento> get(int pagina, int tamano);
}
