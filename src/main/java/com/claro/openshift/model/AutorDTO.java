package com.claro.openshift.model;

public class AutorDTO {
    
    private int id;
    private String nombre; 

    public AutorDTO() {
    }

    public AutorDTO(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    
     
    


}
