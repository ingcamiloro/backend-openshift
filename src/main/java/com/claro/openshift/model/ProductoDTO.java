package com.claro.openshift.model;

import java.util.Date;
import java.util.List;

public class ProductoDTO {
    

    private int id_producto;
    private int id_Categoria;
    private String tipo;
    private Date FECHA_inactivacion;
    private Date FECHA_LLEGADA_BIBLIOTECA;
    private int CANTIDAD_ejemplares;
    private String nombre_categoria;
    private int max_PERIODO_prestamo;
    private String titulo;
    private int cantidad_ejemplares_disponibles;
    private List<AutorDTO>autores;

    

    
    public ProductoDTO() {
    }
    public ProductoDTO(int id_producto, int id_Categoria, String tipo, Date fECHA_inactivacion,
            Date fECHA_LLEGADA_BIBLIOTECA, int cANTIDAD_ejemplares, String nombre_categoria, int max_PERIODO_prestamo,
            String titulo, int cantidad_ejemplares_disponibles, List<AutorDTO> autores) {
        this.id_producto = id_producto;
        this.id_Categoria = id_Categoria;
        this.tipo = tipo;
        FECHA_inactivacion = fECHA_inactivacion;
        FECHA_LLEGADA_BIBLIOTECA = fECHA_LLEGADA_BIBLIOTECA;
        CANTIDAD_ejemplares = cANTIDAD_ejemplares;
        this.nombre_categoria = nombre_categoria;
        this.max_PERIODO_prestamo = max_PERIODO_prestamo;
        this.titulo = titulo;
        this.cantidad_ejemplares_disponibles = cantidad_ejemplares_disponibles;
        this.autores = autores;
    }
    public int getId_producto() {
        return id_producto;
    }
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }
    public int getId_Categoria() {
        return id_Categoria;
    }
    public void setId_Categoria(int id_Categoria) {
        this.id_Categoria = id_Categoria;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Date getFECHA_inactivacion() {
        return FECHA_inactivacion;
    }
    public void setFECHA_inactivacion(Date fECHA_inactivacion) {
        FECHA_inactivacion = fECHA_inactivacion;
    }
    public Date getFECHA_LLEGADA_BIBLIOTECA() {
        return FECHA_LLEGADA_BIBLIOTECA;
    }
    public void setFECHA_LLEGADA_BIBLIOTECA(Date fECHA_LLEGADA_BIBLIOTECA) {
        FECHA_LLEGADA_BIBLIOTECA = fECHA_LLEGADA_BIBLIOTECA;
    }
    public int getCANTIDAD_ejemplares() {
        return CANTIDAD_ejemplares;
    }
    public void setCANTIDAD_ejemplares(int cANTIDAD_ejemplares) {
        CANTIDAD_ejemplares = cANTIDAD_ejemplares;
    }
    public String getNombre_categoria() {
        return nombre_categoria;
    }
    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }
    public int getMax_PERIODO_prestamo() {
        return max_PERIODO_prestamo;
    }
    public void setMax_PERIODO_prestamo(int max_PERIODO_prestamo) {
        this.max_PERIODO_prestamo = max_PERIODO_prestamo;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getCantidad_ejemplares_disponibles() {
        return cantidad_ejemplares_disponibles;
    }
    public void setCantidad_ejemplares_disponibles(int cantidad_ejemplares_disponibles) {
        this.cantidad_ejemplares_disponibles = cantidad_ejemplares_disponibles;
    }
    public List<AutorDTO> getAutores() {
        return autores;
    }
    public void setAutores(List<AutorDTO> autores) {
        this.autores = autores;
    }


}
