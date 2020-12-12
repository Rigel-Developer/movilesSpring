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
@Table(name = "tb_tipo_usuario")
public class TipoUsuario implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_tipo_usuario")
	private int codigoTipoUsuario;
	
	
	@Column(name ="desc_tipo_usuario")
	private String descripcionTipoUsuario;
	
	//relacion 1 a muchos con Alumno
	@JsonIgnore
	@OneToMany(mappedBy="tipoUsuario")
	private List<Alumno> listaTipoAlumno;
	
	//relacion 1 a muchos con Docente
	@JsonIgnore
	@OneToMany(mappedBy="tipoUsuario")
	private List<Docente> listaTipoDocente;

	public int getCodigoTipoUsuario() {
		return codigoTipoUsuario;
	}

	public void setCodigoTipoUsuario(int codigoTipoUsuario) {
		this.codigoTipoUsuario = codigoTipoUsuario;
	}

	public String getDescripcionTipoUsuario() {
		return descripcionTipoUsuario;
	}

	public void setDescripcionTipoUsuario(String descripcionTipoUsuario) {
		this.descripcionTipoUsuario = descripcionTipoUsuario;
	}

	public List<Alumno> getListaTipoAlumno() {
		return listaTipoAlumno;
	}

	public void setListaTipoAlumno(List<Alumno> listaTipoAlumno) {
		this.listaTipoAlumno = listaTipoAlumno;
	}

	public List<Docente> getListaTipoDocente() {
		return listaTipoDocente;
	}

	public void setListaTipoDocente(List<Docente> listaTipoDocente) {
		this.listaTipoDocente = listaTipoDocente;
	}
	
}
