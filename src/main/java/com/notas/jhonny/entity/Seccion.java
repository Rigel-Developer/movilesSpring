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
@Table(name = "tb_seccion")
public class Seccion implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_seccion")
	private int codigoSeccion;
	
	@Column(name = "vacantes")
	private int vacantesSeccion;
	
	public CodigoSeccion getSeccion_code() {
		return seccion_code;
	}

	public void setSeccion_code(CodigoSeccion seccion_code) {
		this.seccion_code = seccion_code;
	}

	@Column(name = "libres")
	private int libresSeccion;
	
	//Muchos a uno con codigoSeccion
	
	@ManyToOne()
	@JoinColumn(name = "id_codigo_seccion")
	private CodigoSeccion seccion_code;
	
	
	//Muchos a uno con Docente
	@ManyToOne()
	@JoinColumn(name = "id_docente")
	private Docente docente;
	
	//Muchos a uno con horario
	
	@ManyToOne()
	@JoinColumn(name = "id_horario")
	private Horario horario;
	
	//Muchos a uno con asignatura
	@ManyToOne()
	@JoinColumn(name = "id_asignatura")
	private Asignatura asignatura;
	
	@JsonIgnore
	@OneToMany(mappedBy = "seccion")//,fetch = FetchType.EAGER)
	private List<AlumnoHasMatricula> listaAlumnoHasMatricula;

	public int getCodigoSeccion() {
		return codigoSeccion;
	}

	public void setCodigoSeccion(int codigoSeccion) {
		this.codigoSeccion = codigoSeccion;
	}

	public int getVacantesSeccion() {
		return vacantesSeccion;
	}

	public void setVacantesSeccion(int vacantesSeccion) {
		this.vacantesSeccion = vacantesSeccion;
	}

	public int getLibresSeccion() {
		return libresSeccion;
	}

	public void setLibresSeccion(int libresSeccion) {
		this.libresSeccion = libresSeccion;
	}



	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public List<AlumnoHasMatricula> getListaAlumnoHasMatricula() {
		return listaAlumnoHasMatricula;
	}

	public void setListaAlumnoHasMatricula(List<AlumnoHasMatricula> listaAlumnoHasMatricula) {
		this.listaAlumnoHasMatricula = listaAlumnoHasMatricula;
	}
	
	
}
