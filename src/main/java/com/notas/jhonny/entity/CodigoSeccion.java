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
@Table(name = "tb_codigo_seccion")
public class CodigoSeccion implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_codigo_seccion")
	private int codigoSeccion;

	@Column(name ="descripcion")
	private String descripcion_codigo;
	
	//Relacion uno a muchos con tabla Seccion
	@JsonIgnore
	@OneToMany(mappedBy="seccion_code")
	private List<Seccion> listaSeccion;

	
	
	public int getCodigoSeccion() {
		return codigoSeccion;
	}

	public void setCodigoSeccion(int codigoSeccion) {
		this.codigoSeccion = codigoSeccion;
	}

	public String getDescripcion_codigo() {
		return descripcion_codigo;
	}

	public void setDescripcion_codigo(String descripcion_codigo) {
		this.descripcion_codigo = descripcion_codigo;
	}

	public List<Seccion> getListaSeccion() {
		return listaSeccion;
	}

	public void setListaSeccion(List<Seccion> listaSeccion) {
		this.listaSeccion = listaSeccion;
	}
	
}
