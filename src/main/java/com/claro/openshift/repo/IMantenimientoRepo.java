package com.claro.openshift.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.claro.openshift.entity.Mantenimiento;
import com.claro.openshift.entity.Producto;

@Repository("mantenimientorepo")
public interface IMantenimientoRepo extends JpaRepository<Mantenimiento, String>{


  
}