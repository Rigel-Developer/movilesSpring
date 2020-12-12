package com.notas.jhonny.entity;


import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_semestre")
public class Semestre implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_semestre")
	private int codigoSemestre;
	
	
	@Column(name ="nom_semestre")
	private String nombreSemestre;

	
	
	//Uno a muchos con Alumno
	@JsonIgnore
	@OneToMany(mappedBy="semestre")
	private List<Alumno> listaAlumno;
	
	
	
	//Uno a muchos con Asignatura
	@JsonIgnore
	@OneToMany(mappedBy="semestre")
	private List<Asignatura> asignatura;

	
	
	public List<Asignatura> getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(List<Asignatura> asignatura) {
		this.asignatura = asignatura;
	}
	
	public int getCodigoSemestre() {
		return codigoSemestre;
	}

	public void setCodigoSemestre(int codigoSemestre) {
		this.codigoSemestre = codigoSemestre;
	}

	public String getNombreSemestre() {
		return nombreSemestre;
	}

	public void setNombreSemestre(String nombreSemestre) {
		this.nombreSemestre = nombreSemestre;
	}

	public List<Alumno> getListaAlumno() {
		return listaAlumno;
	}

	public void setListaAlumno(List<Alumno> listaAlumno) {
		this.listaAlumno = listaAlumno;
	}


	
}
