package com.claro.openshift.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="categoria")
@Entity
public class Categoria {    
    @Id
    @GeneratedValue( strategy=GenerationType.AUTO )
    @Column(name="id_categoria")
    private int id;
    @Column(name="nombre")
    private String nombre;
  

    public Categoria() {
    }

    

    public Categoria(String nombre) {
        this.nombre = nombre;
    }



    public Categoria(int id, String nombre) {
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
