package com.notas.jhonny.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_alumno")
public class Alumno implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_alumno")
	private int codigoAlumno;
	
	@Column(name ="estado_matricula")
	private byte estadoMatri;
	


	@Column(name ="nom_alumno")
	private String nombreAlumno;
	
	@Column(name ="ape_alumno")
	private String apellidoAlumno;
	
	@Column(name ="dni_alumno")
	private int dniAlumno;
	
	@Column(name ="cel_alumno")
	private int celularAlumno;
	
	@Column(name ="correo_alumno")
	private String correoAlumno;
	
	@Column(name ="contra_alumno")
	private String contraAlumno;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name ="fecha_registro_alumno")
	private Date fechaRegistroAlumno;
	
	//Muchos a uno con Carrera
	@ManyToOne()
	@JoinColumn(name = "id_carrera")
	private Carrera carrera;
	
	//Muchos a uno con Semestre
	@ManyToOne()
	@JoinColumn(name = "id_semestre")
	private Semestre semestre;
	
	
	//Muchos a uno con TipoUsuario
	@ManyToOne()
	@JoinColumn(name = "id_tipo_usuario")
	private TipoUsuario tipoUsuario;
	
	//1 a muchos con Notas
	@JsonIgnore
	@OneToMany(mappedBy="alumno")
	private List<AlumnoHasNotas> listaNotas;
	
	//uno a muchos con Alumnos has Matricula
	@JsonIgnore
	@OneToMany(mappedBy = "alumno")//,fetch = FetchType.EAGER)
	private List<AlumnoHasMatricula> listaAlumnoHasDetalle;
	
	
	

	public byte getEstadoMatri() {
		return estadoMatri;
	}

	public void setEstadoMatri(byte estadoMatri) {
		this.estadoMatri = estadoMatri;
	}
	
	public int getCodigoAlumno() {
		return codigoAlumno;
	}

	public void setCodigoAlumno(int codigoAlumno) {
		this.codigoAlumno = codigoAlumno;
	}

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public String getApellidoAlumno() {
		return apellidoAlumno;
	}

	public void setApellidoAlumno(String apellidoAlumno) {
		this.apellidoAlumno = apellidoAlumno;
	}

	public int getDniAlumno() {
		return dniAlumno;
	}

	public void setDniAlumno(int dniAlumno) {
		this.dniAlumno = dniAlumno;
	}

	public int getCelularAlumno() {
		return celularAlumno;
	}

	public void setCelularAlumno(int celularAlumno) {
		this.celularAlumno = celularAlumno;
	}

	public String getCorreoAlumno() {
		return correoAlumno;
	}

	public void setCorreoAlumno(String correoAlumno) {
		this.correoAlumno = correoAlumno;
	}

	public String getContraAlumno() {
		return contraAlumno;
	}

	public void setContraAlumno(String contraAlumno) {
		this.contraAlumno = contraAlumno;
	}

	public Date getFechaRegistroAlumno() {
		return fechaRegistroAlumno;
	}

	public void setFechaRegistroAlumno(Date fechaRegistroAlumno) {
		this.fechaRegistroAlumno = fechaRegistroAlumno;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public List<AlumnoHasNotas> getListaNotas() {
		return listaNotas;
	}

	public void setListaNotas(List<AlumnoHasNotas> listaNotas) {
		this.listaNotas = listaNotas;
	}

	public List<AlumnoHasMatricula> getListaAlumnoHasDetalle() {
		return listaAlumnoHasDetalle;
	}

	public void setListaAlumnoHasDetalle(List<AlumnoHasMatricula> listaAlumnoHasDetalle) {
		this.listaAlumnoHasDetalle = listaAlumnoHasDetalle;
	}


	

}
