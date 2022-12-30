package com.claro.openshift.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.claro.openshift.entity.Producto;

public interface IProductoService {
    public Producto consultar(Map<String,Object> mapa);

    public Producto crear(Producto producto);  
    public Map<String,Object> getList();
    public Page<Producto> get(int pagina, int tamano);
}
