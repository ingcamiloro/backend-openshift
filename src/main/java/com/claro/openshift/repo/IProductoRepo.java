package com.claro.openshift.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.claro.openshift.entity.Producto;

@Repository("productorepo")
public interface IProductoRepo extends JpaRepository<Producto, String>{
  
}