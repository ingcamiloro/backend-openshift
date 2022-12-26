package com.claro.openshift.model;

import java.util.Date;

public class ProductoDTO {
    
    private int id;
    private String titulo;
    private CategoriaDTO categoria;
    private String tipoProducto;
    private int cantidadEjemplares;
    private int periodoMaximoPrestamo;
    private Date fechaInactivacion;
    private Date fechaIngreso;    

    public ProductoDTO() {
    }

    

    public ProductoDTO(int id, String titulo, CategoriaDTO categoria, String tipoProducto, int cantidadEjemplares,
            int periodoMaximoPrestamo, Date fechaInactivacion, Date fechaIngreso) {
        this.id = id;
        this.titulo = titulo;
        this.categoria = categoria;
        this.tipoProducto = tipoProducto;
        this.cantidadEjemplares = cantidadEjemplares;
        this.periodoMaximoPrestamo = periodoMaximoPrestamo;
        this.fechaInactivacion = fechaInactivacion;
        this.fechaIngreso = fechaIngreso;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public CategoriaDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDTO categoria) {
        this.categoria = categoria;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public int getCantidadEjemplares() {
        return cantidadEjemplares;
    }

    public void setCantidadEjemplares(int cantidadEjemplares) {
        this.cantidadEjemplares = cantidadEjemplares;
    }

    public int getPeriodoMaximoPrestamo() {
        return periodoMaximoPrestamo;
    }

    public void setPeriodoMaximoPrestamo(int periodoMaximoPrestamo) {
        this.periodoMaximoPrestamo = periodoMaximoPrestamo;
    }

    public Date getFechaInactivacion() {
        return fechaInactivacion;
    }

    public void setFechaInactivacion(Date fechaInactivacion) {
        this.fechaInactivacion = fechaInactivacion;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }


}
