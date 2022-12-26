package com.claro.openshift.service;

import java.util.List;
import java.util.Map;

import com.claro.openshift.model.ProductoDTO;

public interface IProductoService {
    public List<ProductoDTO> consultar(ProductoDTO libro);

    public ProductoDTO crear(ProductoDTO producto);

    public Map<String,Object> get(int pagina, int tamano);
}
