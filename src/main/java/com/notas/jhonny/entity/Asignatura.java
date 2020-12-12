package com.notas.jhonny.entity;


import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_asignatura")
public class Asignatura implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_asignatura")
	private int codigoAsignatura;
	
	
	@Column(name ="nom_asignatura")
	private String nombreAsignatura;
	
	//Muchos a uno con Semestre
	@ManyToOne()
	@JoinColumn(name = "id_semestre")
	private Semestre semestre;
	
	//Muchos a uno con Carrera
	@ManyToOne()
	@JoinColumn(name = "id_carrera")
	private Carrera carrera;
	
	
	

	
	@JsonIgnore
	@OneToMany(mappedBy="asignatura")
	private List<AlumnoHasNotas> listaNotas;
	
	//Relacion uno 1 muchos con Seccion
	@JsonIgnore
	@OneToMany(mappedBy="asignatura")
	private List<Seccion> listaSeccion;

	
	
	
	
	public int getCodigoAsignatura() {
		return codigoAsignatura;
	}

	public void setCodigoAsignatura(int codigoAsignatura) {
		this.codigoAsignatura = codigoAsignatura;
	}

	public String getNombreAsignatura() {
		return nombreAsignatura;
	}

	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public List<Seccion> getListaSeccion() {
		return listaSeccion;
	}

	public void setListaSeccion(List<Seccion> listaSeccion) {
		this.listaSeccion = listaSeccion;
	}

	public List<AlumnoHasNotas> getListaNotas() {
		return listaNotas;
	}

	public void setListaNotas(List<AlumnoHasNotas> listaNotas) {
		this.listaNotas = listaNotas;
	}

	
	
	
	
}
