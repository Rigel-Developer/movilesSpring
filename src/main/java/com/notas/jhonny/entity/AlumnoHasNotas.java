package com.notas.jhonny.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_notas")
public class AlumnoHasNotas implements Serializable{


	@EmbeddedId
	private AlumnosHasNotasPK pk;
	
	@ManyToOne
	@JoinColumn(name = "id_asignatura", referencedColumnName = "id_asignatura",insertable = false,updatable = false)
	private Asignatura asignatura;//ASOC
	
	@ManyToOne
	@JoinColumn(name = "id_alumno", referencedColumnName = "id_alumno",insertable = false,updatable = false)
	private Alumno alumno;//ASOC
	
	
	
	
	@Column(name ="caso_1")
	private double caso_1;
	
	@Column(name ="caso_2")
	private double caso_2;
	
	@Column(name ="caso_3")
	private double caso_3;
	
	
	@Column(name ="caso_virtual")
	private double casoVirtual;

	@Column(name ="notaFinal")
	private double notaFinal;

	public AlumnosHasNotasPK getPk() {
		return pk;
	}

	public void setPk(AlumnosHasNotasPK pk) {
		this.pk = pk;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public double getCaso_1() {
		return caso_1;
	}

	public void setCaso_1(double caso_1) {
		this.caso_1 = caso_1;
	}

	public double getCaso_2() {
		return caso_2;
	}

	public void setCaso_2(double caso_2) {
		this.caso_2 = caso_2;
	}

	public double getCaso_3() {
		return caso_3;
	}

	public void setCaso_3(double caso_3) {
		this.caso_3 = caso_3;
	}

	public double getCasoVirtual() {
		return casoVirtual;
	}

	public void setCasoVirtual(double casoVirtual) {
		this.casoVirtual = casoVirtual;
	}

	public double getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(double notaFinal) {
		this.notaFinal = notaFinal;
	}


	
	
	
	
	
	
}
