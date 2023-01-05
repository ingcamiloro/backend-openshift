package com.claro.openshift.model;

public class PropiedadesDTO {
    
    private String accion;
    private String canal;    
    private String codapp;
    private String nombre;    
    private String valor;



    
    public PropiedadesDTO() {
    }
    public PropiedadesDTO(String accion, String canal, String codapp, String nombre, String valor) {
        this.accion = accion;
        this.canal = canal;
        this.codapp = codapp;
        this.nombre = nombre;
        this.valor = valor;
    }
    public String getAccion() {
        return accion;
    }
    public void setAccion(String accion) {
        this.accion = accion;
    }
    public String getCanal() {
        return canal;
    }
    public void setCanal(String canal) {
        this.canal = canal;
    }
    public String getCodapp() {
        return codapp;
    }
    public void setCodapp(String codapp) {
        this.codapp = codapp;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }


    

}