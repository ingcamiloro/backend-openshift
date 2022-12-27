package com.claro.openshift.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name="mantenimiento")
@Entity
public class Mantenimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_mantenimiento")
    private int id;


    @Column(name="fechaInicioMantenimiento")
    private Date fechaInicioMantenimiento;

    @Column(name="fechaFinMantenimiento")
    private Date fechaFinMantenimiento;

    @JsonIgnore
	@ManyToOne	
	@JoinColumn(name="fk_id_producto")
	private Producto producto;

    public Mantenimiento() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaInicioMantenimiento() {
        return fechaInicioMantenimiento;
    }

    public void setFechaInicioMantenimiento(Date fechaInicioMantenimiento) {
        this.fechaInicioMantenimiento = fechaInicioMantenimiento;
    }

    public Date getFechaFinMantenimiento() {
        return fechaFinMantenimiento;
    }

    public void setFechaFinMantenimiento(Date fechaFinMantenimiento) {
        this.fechaFinMantenimiento = fechaFinMantenimiento;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }


    


}
