package com.notas.jhonny.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notas.jhonny.entity.Docente;
import com.notas.jhonny.entity.Horario;
import com.notas.jhonny.repository.DocenteDAO;

@Service
public class DocenteService {

	
	@Autowired
	private DocenteDAO docenteDAO;
	
	public Docente loginDocente(String user , String pass) {
		return docenteDAO.loginDocente(user, pass);
	}
	
	
	
	public List<Horario>verHorariosXDocente(int cod){
		return docenteDAO.verHorariosXDocente(cod);
	}
	
	
}
