package com.notas.jhonny.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AlumnoHasMatriculaPK implements Serializable{

	@Column(name ="id_alumno")
	private int codigoAlumno;
	
	@Column(name ="id_seccion")
	private int codigoSeccion;

	public int getCodigoAlumno() {
		return codigoAlumno;
	}

	public void setCodigoAlumno(int codigoAlumno) {
		this.codigoAlumno = codigoAlumno;
	}

	public int getCodigoSeccion() {
		return codigoSeccion;
	}

	public void setCodigoSeccion(int codigoSeccion) {
		this.codigoSeccion = codigoSeccion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoAlumno;
		result = prime * result + codigoSeccion;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlumnoHasMatriculaPK other = (AlumnoHasMatriculaPK) obj;
		if (codigoAlumno != other.codigoAlumno)
			return false;
		if (codigoSeccion != other.codigoSeccion)
			return false;
		return true;
	}


	

	
	
	
	
}
