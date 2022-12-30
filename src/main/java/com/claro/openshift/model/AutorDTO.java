package com.claro.openshift.model;

public class AutorDTO {
    
    private int id_autor;
    private String nombre_autor; 



    public AutorDTO(int id_autor, String nombre_autor) {
        this.id_autor = id_autor;
        this.nombre_autor = nombre_autor;
    }



    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public String getNombre_autor() {
        return nombre_autor;
    }



    public void setNombre_autor(String nombre_autor) {
        this.nombre_autor = nombre_autor;
    }


    

}