package com.claro.openshift.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.claro.openshift.entity.Producto;
import com.claro.openshift.model.ProductoDTO;

public interface IProductoService {
    public List<Producto> consultar();

    public ProductoDTO crear(Producto producto);
    

    public Page<Producto> get(int pagina, int tamano);
}
