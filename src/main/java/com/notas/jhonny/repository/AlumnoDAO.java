package com.notas.jhonny.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.notas.jhonny.entity.Alumno;
import com.notas.jhonny.entity.AlumnoHasMatricula;
import com.notas.jhonny.entity.Asignatura;
import com.notas.jhonny.entity.Horario;
import com.notas.jhonny.entity.Seccion;

public interface AlumnoDAO extends JpaRepository<Alumno, Integer>{
	
	//yo como alumno dese poder iniciar sesion con mis credenciales
	@Query("select a from Alumno a where a.correoAlumno = :s1 and a.contraAlumno = :s2")
	public Alumno login(@Param("s1") String user, @Param("s2") String pass);
	
	//ver los cursos segun semestre y carrera
	@Query("select a from Asignatura a join a.carrera c join a.semestre s where c.codigoCarrera = :s1 and s.codigoSemestre = :s2")
	public List<Asignatura> verCursos(@Param("s1") int carrera,@Param("s2") int semestre );
	
	//ver mis cursos horarios y profesores
	@Query("select ahm from AlumnoHasMatricula ahm join ahm.seccion s join ahm.alumno al where s.codigoSeccion = :s1")
	public List<AlumnoHasMatricula> verCursoHorarioProfesor(@Param("s1") int codigo);
	
	//ver mis cursos por alumno
	@Query("select a from AlumnoHasMatricula ahm join ahm.alumno al join ahm.seccion s join s.asignatura a where al.codigoAlumno = :s1")
	public List<Asignatura> verCursosXAlumno(@Param("s1") int alumno);
	
	
	
	//Ver todos los horarios
	@Query("select h from Horario h")
	public List<Horario>verTodosHorarios();
	
	//ver horario por alumno
	@Query("select h from AlumnoHasMatricula ahm join ahm.seccion s join ahm.alumno a join s.horario h where a.codigoAlumno = :s1")
	public List<Horario>verHorariosXAlumno(@Param("s1") int cod);
	
	//ver Horario por asignatura
	@Query("select s from Seccion s join s.asignatura a join s.horario h where a.codigoAsignatura= :s1 ")
	public List<Seccion>verHorariosXAsignatura(@Param("s1") int cod);
	
	//ver Seccion por asignatura
	@Query("select s from AlumnoHasMatricula ahm join  ahm.seccion s join ahm.alumno a where a.codigoAlumno= :s1 ")
	public List<Seccion>verSeccioXAlumno(@Param("s1") int cod);
	
	//Ver seccion por Docente
	@Query("select s from Seccion s join s.docente d where d.codigoDocente= :s1 ")
	public List<Seccion>verSeccioXDocente(@Param("s1") int cod);
	
	
	
	
	
	//Matricularme
	
	@Query("select a from Alumno a where a.codigoAlumno = :s1")
	public Alumno buscarAlumno(@Param("s1") int user);
	
	
	//Ver Alumnos Segun Seccion
	
	@Query("select a from AlumnoHasMatricula ahm join ahm.seccion s join ahm.alumno a where s.codigoSeccion = :s1")
	public List<Alumno> buscarAlumnoXSeccion(@Param("s1") int user);

	
}
