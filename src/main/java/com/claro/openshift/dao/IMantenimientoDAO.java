package com.claro.openshift.dao;

import org.springframework.data.domain.Page;

import com.claro.openshift.entity.Mantenimiento;

public interface IMantenimientoDAO {
    public Mantenimiento crear(Mantenimiento mantenimiento);
    public Page<Mantenimiento> get(int pagina, int tamano);   
}
