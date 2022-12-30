package com.claro.openshift.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(name="producto")
@Entity
public class Producto {
   
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
	private int id;
	
	@ManyToOne	
	@JoinColumn(name="fk_idCategoria")
	private Categoria categoria;

	@Column(name="tipoProducto")
	private String tipoProducto;

	@Column(name="cantidadEjemplares")
	private int cantidadEjemplares;

	@Column(name="periodoMaximoPrestamo")
	private int periodoMaximoPrestamo;
	
	@Column(name="titulo")
	private String titulo;

	@Column(name="fechaInactivacion")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date fechaInActivacion;

	@Column(name="fechaIngreso")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date fechaIngreso;

	// @JsonIgnoreProperties("producto")
	@ManyToMany
	@JsonIgnoreProperties("producto")
    @JoinTable(name = "autorlibro", joinColumns = {
            @JoinColumn(name = "fk_producto", referencedColumnName = "id_producto") }, inverseJoinColumns = {
                    @JoinColumn(name = "fk_id_autor", referencedColumnName = "id_autor",unique=true) })
    private List<Autor> autores = new ArrayList<>();


	@OneToMany(mappedBy = "producto")
    List<Mantenimiento> mantenimientos;
	

	public Producto() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFechaInActivacion() {
		return fechaInActivacion;
	}

	public void setFechaInActivacion(Date fechaInActivacion) {
		this.fechaInActivacion = fechaInActivacion;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public List<Mantenimiento> getMantenimientos() {
		return mantenimientos;
	}

	public void setMantenimientos(List<Mantenimiento> mantenimientos) {
		this.mantenimientos = mantenimientos;
	}



}
