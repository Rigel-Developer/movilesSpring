package com.notas.jhonny.entity;


import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_matricula")
public class AlumnoHasMatricula implements Serializable {

	@EmbeddedId
	private AlumnoHasMatriculaPK pk;
	
	@ManyToOne
	@JoinColumn(name = "id_alumno", referencedColumnName = "id_alumno",insertable = false,updatable = false)
	private Alumno alumno;//ASOC
	
	@ManyToOne
	@JoinColumn(name = "id_seccion", referencedColumnName = "id_seccion",insertable = false,updatable = false)
	private Seccion seccion;//ASOC

	
	
	public AlumnoHasMatriculaPK getPk() {
		return pk;
	}

	public void setPk(AlumnoHasMatriculaPK pk) {
		this.pk = pk;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}

}
