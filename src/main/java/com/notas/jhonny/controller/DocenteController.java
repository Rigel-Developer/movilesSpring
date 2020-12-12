package com.notas.jhonny.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notas.jhonny.entity.AlumnoHasMatricula;
import com.notas.jhonny.entity.Docente;
import com.notas.jhonny.entity.Horario;
import com.notas.jhonny.service.DocenteService;

@CrossOrigin( origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value ="/docente")
public class DocenteController {

	
	@Autowired
	private DocenteService docenteService;
	
	@GetMapping("/verHorarioXDocente/{codigo}")
	public List<Horario> verHorarioXDocente(@PathVariable("codigo") int codigo) {
		return docenteService.verHorariosXDocente(codigo);
	}
	
	@GetMapping("/loginDocente/{user}/{pass}")
	public Docente loginDocente(@PathVariable("user") String user,@PathVariable("pass") String pass) {
		return docenteService.loginDocente(user, pass);
	}
	
	
	
	
}
