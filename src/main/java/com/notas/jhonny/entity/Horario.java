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
@Table(name = "tb_horario")
public class Horario implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_horario")
	private int codigoHorario;
	
	@Column(name ="turno")
	private String turnoHorario;
	
	@Column(name ="dia")
	private String diaHorario;
	
	@Column(name ="hora_inicio")
	private String horaInicioHorario;
	
	@Column(name ="hora_fin")
	private String horaFinHorario;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "horario")//,fetch = FetchType.EAGER)
	private List<Seccion> listaSeccionHorario;

	
	

	public List<Seccion> getListaSeccionHorario() {
		return listaSeccionHorario;
	}

	public void setListaSeccionHorario(List<Seccion> listaSeccionHorario) {
		this.listaSeccionHorario = listaSeccionHorario;
	}

	public int getCodigoHorario() {
		return codigoHorario;
	}

	public void setCodigoHorario(int codigoHorario) {
		this.codigoHorario = codigoHorario;
	}

	public String getTurnoHorario() {
		return turnoHorario;
	}

	public void setTurnoHorario(String turnoHorario) {
		this.turnoHorario = turnoHorario;
	}

	public String getDiaHorario() {
		return diaHorario;
	}

	public void setDiaHorario(String diaHorario) {
		this.diaHorario = diaHorario;
	}

	public String getHoraInicioHorario() {
		return horaInicioHorario;
	}

	public void setHoraInicioHorario(String horaInicioHorario) {
		this.horaInicioHorario = horaInicioHorario;
	}

	public String getHoraFinHorario() {
		return horaFinHorario;
	}

	public void setHoraFinHorario(String horaFinHorario) {
		this.horaFinHorario = horaFinHorario;
	}


}
