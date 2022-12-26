package com.claro.openshift.dao;

import java.util.List;
import java.util.Map;

import com.claro.openshift.model.ProductoDTO;

public interface  IProductoDAO {
    public List<ProductoDTO> consultar(ProductoDTO libro);

    public Map<String,Object> get(int pagina, int tamano);

    
    public ProductoDTO crear(ProductoDTO producto);
  
}
