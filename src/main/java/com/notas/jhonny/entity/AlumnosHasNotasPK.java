package com.notas.jhonny.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AlumnosHasNotasPK implements Serializable{

	@Column(name ="id_asignatura")
	private int codigoAsignatura;
	
	@Column(name ="id_alumno")
	private int codigoAlumno;

	public int getCodigoAsignatura() {
		return codigoAsignatura;
	}

	public void setCodigoAsignatura(int codigoAsignatura) {
		this.codigoAsignatura = codigoAsignatura;
	}

	public int getCodigoAlumno() {
		return codigoAlumno;
	}

	public void setCodigoAlumno(int codigoAlumno) {
		this.codigoAlumno = codigoAlumno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoAlumno;
		result = prime * result + codigoAsignatura;
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
		AlumnosHasNotasPK other = (AlumnosHasNotasPK) obj;
		if (codigoAlumno != other.codigoAlumno)
			return false;
		if (codigoAsignatura != other.codigoAsignatura)
			return false;
		return true;
	}
	

	




	

	

	
}
