package com.notas.jhonny.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.notas.jhonny.entity.Alumno;
import com.notas.jhonny.entity.AlumnoHasMatricula;
import com.notas.jhonny.entity.AlumnoHasMatriculaPK;
import com.notas.jhonny.entity.AlumnoHasNotas;
import com.notas.jhonny.entity.AlumnosHasNotasPK;
import com.notas.jhonny.entity.Asignatura;
import com.notas.jhonny.entity.Horario;
import com.notas.jhonny.entity.Seccion;
import com.notas.jhonny.service.AlumnoService;

@CrossOrigin( origins = {"http://localhost:4200","http://10.0.2.2:8090"})
@RestController
@RequestMapping(value ="/alumno")
public class AlumnoController {

	
	@Autowired
	private AlumnoService alumnoService;
	
	
	@GetMapping("/getAlumno/{user}")
	public Alumno getAlumno(@PathVariable("user") int user) {
		return alumnoService.buscarAlumno(user);
	}	
	
	
	//Seccion por asignatura

	@GetMapping("/verHorariosXAsignatura/{codigo}")
	public List<Seccion> verHorariosXAsignatura(@PathVariable("codigo") int codigo) {
		return alumnoService.verHorariosXAsignatura(codigo);
	}
	
	//Login
	@GetMapping("/login/{user}/{pass}")
	public ResponseEntity<?> login(@PathVariable("user") String user,@PathVariable("pass") String pass) {
		Alumno alumno = null;
		Map<String, Object>response = new HashMap<>();
		try {
			alumno = alumnoService.login(user, pass);
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la consulta en la base de datos ");
			response.put("Error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()) );
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		
		if(alumno == null) {
			response.put("Mensaje", "El alumno con Correo: ".concat(user.concat("No existe en la base de datos")));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Alumno>(alumno,HttpStatus.OK);
		
	}
	
	
	
	//Curso x alumno
	
	@GetMapping("/verCursosXAlumno/{alumno}")
	public List<Asignatura> verCursosXAlumno(@PathVariable("alumno") int alumno) {
		return alumnoService.verCursosXAlumno(alumno);
	}
	
	
	@GetMapping("/verHorario/{codigo}")
	public List<AlumnoHasMatricula> verHorario(@PathVariable("codigo") int codigo) {
		return alumnoService.verCursoHorarioProfesor(codigo);
	}
	
	@GetMapping("/verTodoHorario")
	public List<Horario> verTodoHorario(){
		return alumnoService.verTodosHorarios();
	}
	
	
	@GetMapping("/verHorarioXAlumno/{codigo}")
	public List<Horario> verHorarioXAlumno(@PathVariable("codigo") int codigo){
		return alumnoService.verHorarioXAlumno(codigo);
	}
	
	@GetMapping("/verSeccioXAlumno/{codigo}")
	public List<Seccion> verSeccioXAlumno(@PathVariable("codigo") int codigo){
		return alumnoService.verSeccioXAlumno(codigo);
	}
	
	
	@GetMapping("/verSeccioXDocente/{codigo}")
	public List<Seccion> verSeccioXDocente(@PathVariable("codigo") int codigo){
		return alumnoService.verSeccioXDocente(codigo);
	}
	
	
	
	@GetMapping("/verCursos/{carrera}/{semestre}")
	public List<Asignatura> verCursos(@PathVariable("carrera") int carrera,@PathVariable("semestre") int semestre){
		return alumnoService.verCursos(carrera, semestre);
	}
	
	
	@PostMapping("/matricula/{alumno}/{seccion}")
	@ResponseStatus(HttpStatus.CREATED)
	public void matricula(@PathVariable("alumno") int alumno,@PathVariable("seccion") int seccion) {
		AlumnoHasMatricula afm = new AlumnoHasMatricula();
		/*Alumno al = alumnoService.buscarAlumno(alumno);
		Seccion s =  alumnoService.buscarSeccion(seccion);*/
		AlumnoHasMatriculaPK pk = new AlumnoHasMatriculaPK();
		pk.setCodigoAlumno(alumno);
		pk.setCodigoSeccion(seccion);
		afm.setPk(pk);

		alumnoService.matricula(afm);
		
	}
	
	@GetMapping("/verNotas/{alumno}")
	public List<AlumnoHasNotas> verNotas(@PathVariable("alumno") int alumno){
		return alumnoService.verNotas(alumno);
	}
	
	@GetMapping("/verNotasXCurso/{alumno}/{curso}")
	public AlumnoHasNotas verNotasXCurso(@PathVariable("alumno") int alumno,@PathVariable("curso") int curso){
		return alumnoService.verNotasXCurso(alumno,curso);
	}
	
	@GetMapping("/buscarAlumnoXSeccion/{seccion}")
	public List<Alumno> buscarAlumnoXSeccion(@PathVariable("seccion") int seccion){
		return alumnoService.buscarAlumnoXSeccion(seccion);
	}
	
	
	@PutMapping("/updateNotas/{alumno}/{curso}")
	@ResponseStatus(HttpStatus.CREATED)
	public void updateNotas(@RequestBody AlumnoHasNotas ahn ,@PathVariable("alumno") int alumno,@PathVariable("curso") int curso) {
		AlumnoHasNotas ahn2 = alumnoService.verNotasXCurso(alumno, curso);
		AlumnosHasNotasPK pk = new AlumnosHasNotasPK();
		System.out.println(ahn.getCaso_2());
		System.out.println("ahn2 -> " + ahn2.getCaso_1());;
		pk.setCodigoAlumno(alumno);
		pk.setCodigoAsignatura(curso);
		
		ahn2.setPk(pk);
		ahn2.setCaso_1(ahn.getCaso_1());
		ahn2.setCaso_2(ahn.getCaso_2());
		ahn2.setCaso_3(ahn.getCaso_3());
		ahn2.setCasoVirtual(ahn.getCasoVirtual());
		ahn2.setNotaFinal(ahn.getNotaFinal());
		
		alumnoService.updateNota(ahn2);
		
		
	}
	
	
	
}
