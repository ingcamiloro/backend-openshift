package com.claro.openshift.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.claro.openshift.entity.Producto;

public interface  IProductoDAO {
    public List<Producto> consultar();

    public Page<Producto> get(int pagina, int tamano);
    
    public Producto crear(Producto producto);
  
}
