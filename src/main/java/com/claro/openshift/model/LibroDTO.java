package com.claro.openshift.model;

import java.util.Date;

public class LibroDTO {
    
    private int id;
    private String tituloLibro;
    private CategoriaDTO categoria;
    private AutorDTO autor;
    private boolean estado;
    private Date fechaLlegadaBiblioteca;
    private int maxPeriodoPrestamo;

    public LibroDTO() {
    }


    public LibroDTO(int id, String tituloLibro, CategoriaDTO categoria, AutorDTO autor, boolean estado,
            Date fechaLlegadaBiblioteca, int maxPeriodoPrestamo) {
        this.id = id;
        this.tituloLibro = tituloLibro;
        this.categoria = categoria;
        this.autor = autor;
        this.estado = estado;
        this.fechaLlegadaBiblioteca = fechaLlegadaBiblioteca;
        this.maxPeriodoPrestamo = maxPeriodoPrestamo;
    }


    public String getTituloLibro() {
        return tituloLibro;
    }
    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }
    public CategoriaDTO getCategoria() {
        return categoria;
    }
    public void setCategoria(CategoriaDTO categoria) {
        this.categoria = categoria;
    }
    public AutorDTO getAutor() {
        return autor;
    }
    public void setAutor(AutorDTO autor) {
        this.autor = autor;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public Date getFechaLlegadaBiblioteca() {
        return fechaLlegadaBiblioteca;
    }
    public void setFechaLlegadaBiblioteca(Date fechaLlegadaBiblioteca) {
        this.fechaLlegadaBiblioteca = fechaLlegadaBiblioteca;
    }
    public int getMaxPeriodoPrestamo() {
        return maxPeriodoPrestamo;
    }
    public void setMaxPeriodoPrestamo(int maxPeriodoPrestamo) {
        this.maxPeriodoPrestamo = maxPeriodoPrestamo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}
