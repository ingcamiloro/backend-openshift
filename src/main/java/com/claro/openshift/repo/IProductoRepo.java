package com.claro.openshift.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.claro.openshift.entity.Producto;

@Repository("productorepo")
public interface IProductoRepo extends JpaRepository<Producto, String>{



    @Query(value = "SELECT * FROM producto where titulo=?", nativeQuery = true)
    Producto buscarProducto(String titulo_libro);
  
}