package com.notas.jhonny.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.notas.jhonny.entity.Alumno;
import com.notas.jhonny.entity.AlumnoHasMatricula;
import com.notas.jhonny.entity.AlumnoHasNotas;
import com.notas.jhonny.entity.Asignatura;
import com.notas.jhonny.entity.Horario;
import com.notas.jhonny.entity.Seccion;
import com.notas.jhonny.repository.AlumnoDAO;
import com.notas.jhonny.repository.AlumnoHasMatriculaDAO;
import com.notas.jhonny.repository.AlumnoHasNotasDAO;
import com.notas.jhonny.repository.SeccionDAO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class AlumnoService {

	@Autowired
	private AlumnoDAO alumnoDAO;
	//private AlumnosDAO alumnosDAO;
	
	@Autowired
	private AlumnoHasMatriculaDAO ahmDAO;
	
	@Autowired
	private SeccionDAO seccionDAO;
	
	@Autowired
	private AlumnoHasNotasDAO ahnDAO;
	
	
	public Alumno login(String user,String pass) {
		return alumnoDAO.login(user, pass);
	}
	
	public List<Seccion>verHorariosXAsignatura(int cod){
		return alumnoDAO.verHorariosXAsignatura(cod);
	}
	
	
	
	public List<AlumnoHasMatricula>verCursoHorarioProfesor(int codigo){
		return alumnoDAO.verCursoHorarioProfesor(codigo);
	}
	
	public List<Horario>verTodosHorarios(){
		return alumnoDAO.verTodosHorarios();
	}
	
	public List<Seccion>verSeccioXAlumno(int cod){
		return alumnoDAO.verSeccioXAlumno(cod);
	}
	
	public List<Horario>verHorarioXAlumno(int cod){
		return alumnoDAO.verHorariosXAlumno(cod);
	}
	
	public List<Asignatura>verCursos(int carrera,int semestre){
		return alumnoDAO.verCursos(carrera, semestre);
	}
	
	public void matricula(AlumnoHasMatricula bean) {
			ahmDAO.save(bean);
	}
	
	public void updateNota(AlumnoHasNotas bean) {
		ahnDAO.save(bean);
	}
	
	
	
	public Alumno buscarAlumno(int id) {
		return alumnoDAO.buscarAlumno(id);
	}
	
	public Seccion buscarSeccion(int id) {
		return seccionDAO.buscarSeccion(id);
	}
	
	public List<AlumnoHasNotas> verNotas(int id) {
		return ahnDAO.verNotas(id);
	}
	public AlumnoHasNotas verNotasXCurso(int alu, int asi) {
		return ahnDAO.verNotasXCurso(alu,asi);
	}
	
	public List<Alumno>buscarAlumnoXSeccion(int cod){
		return alumnoDAO.buscarAlumnoXSeccion(cod);
	}
	
	
	//Asignatura x Alumno
	public List<Asignatura>verCursosXAlumno(int alumno){
		return alumnoDAO.verCursosXAlumno(alumno);
	}
	
	//---------------------->DOCENTE<---------------------------
	
	public List<Seccion>verSeccioXDocente(int cod){
		return alumnoDAO.verSeccioXDocente(cod);
	}
	
	
	
	
	
	
}
