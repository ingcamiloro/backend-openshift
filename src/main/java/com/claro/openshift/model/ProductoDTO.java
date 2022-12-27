package com.claro.openshift.model;

import java.util.Date;

public class ProductoDTO {
    
    private int id_categoria;
    private int id_autor;
    private int estado;
    private String titulo_libro;
    private Date fecha_llegada_biblioteca;
    private int max_PERIODO_prestamo;



    
    public ProductoDTO() {
    }
    public int getId_categoria() {
        return id_categoria;
    }
    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
    public int getId_autor() {
        return id_autor;
    }
    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }
    public int getEstado() {
        return estado;
    }
    public void setEstado(int estado) {
        this.estado = estado;
    }
    public String getTitulo_libro() {
        return titulo_libro;
    }
    public void setTitulo_libro(String titulo_libro) {
        this.titulo_libro = titulo_libro;
    }
    public Date getFecha_llegada_biblioteca() {
        return fecha_llegada_biblioteca;
    }
    public void setFecha_llegada_biblioteca(Date fecha_llegada_biblioteca) {
        this.fecha_llegada_biblioteca = fecha_llegada_biblioteca;
    }
    public int getMax_PERIODO_prestamo() {
        return max_PERIODO_prestamo;
    }
    public void setMax_PERIODO_prestamo(int max_PERIODO_prestamo) {
        this.max_PERIODO_prestamo = max_PERIODO_prestamo;
    }


    

}
