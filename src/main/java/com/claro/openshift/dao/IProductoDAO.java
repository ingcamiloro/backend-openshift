package com.claro.openshift.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.claro.openshift.entity.Producto;
import com.claro.openshift.model.ProductoDTO;

public interface  IProductoDAO {
    public List<Producto> consultar();

    public Page<Producto> get(int pagina, int tamano);
    
    public ProductoDTO crear(Producto producto);
  
}
