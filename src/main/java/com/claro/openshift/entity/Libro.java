package com.claro.openshift.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Table(name="producto")
@Entity
public class Libro {
   
	
    @Id
    @GeneratedValue( strategy=GenerationType.AUTO )
    @Column(name="id_producto")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idCategoria")
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



}
