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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_docente")
public class Docente implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_docente")
	private int codigoDocente;
	
	@Column(name ="nom_docente")
	private String nombreDocente;
	
	@Column(name ="ape_docente")
	private String apellidoDocente;
	
	@Column(name ="dni_docente")
	private int dniDocente;
	
	@Column(name ="cel_docente")
	private int celularDocenteo;
	
	@Column(name ="correo_docente")
	private String correoDocente;
	
	@Column(name ="contra_docente")
	private String contraDocente;
	
	@Column(name ="fecha_registro_docente")
	private Date fechaRegistroDocente;
	
	//Muchos a uno con TipoUsuario
	@ManyToOne()
	@JoinColumn(name = "id_tipo_usuario")
	private TipoUsuario tipoUsuario;
	
	//Uno a muchos con Seccion
	@JsonIgnore
	@OneToMany(mappedBy="docente")
	private List<Seccion> listaSeccion;


	public int getCodigoDocente() {
		return codigoDocente;
	}


	public void setCodigoDocente(int codigoDocente) {
		this.codigoDocente = codigoDocente;
	}


	public String getNombreDocente() {
		return nombreDocente;
	}


	public void setNombreDocente(String nombreDocente) {
		this.nombreDocente = nombreDocente;
	}


	public String getApellidoDocente() {
		return apellidoDocente;
	}


	public void setApellidoDocente(String apellidoDocente) {
		this.apellidoDocente = apellidoDocente;
	}


	public int getDniDocente() {
		return dniDocente;
	}


	public void setDniDocente(int dniDocente) {
		this.dniDocente = dniDocente;
	}


	public int getCelularDocenteo() {
		return celularDocenteo;
	}


	public void setCelularDocenteo(int celularDocenteo) {
		this.celularDocenteo = celularDocenteo;
	}


	public String getCorreoDocente() {
		return correoDocente;
	}


	public void setCorreoDocente(String correoDocente) {
		this.correoDocente = correoDocente;
	}


	public String getContraDocente() {
		return contraDocente;
	}


	public void setContraDocente(String contraDocente) {
		this.contraDocente = contraDocente;
	}


	public Date getFechaRegistroDocente() {
		return fechaRegistroDocente;
	}


	public void setFechaRegistroDocente(Date fechaRegistroDocente) {
		this.fechaRegistroDocente = fechaRegistroDocente;
	}


	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}


	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}


	public List<Seccion> getListaSeccion() {
		return listaSeccion;
	}


	public void setListaSeccion(List<Seccion> listaSeccion) {
		this.listaSeccion = listaSeccion;
	}
	
	
}
