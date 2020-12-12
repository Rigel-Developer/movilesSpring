package com.notas.jhonny.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.notas.jhonny.entity.AlumnoHasNotas;

public interface AlumnoHasNotasDAO extends JpaRepository<AlumnoHasNotas, Integer> {
	
	@Query("select ahn from AlumnoHasNotas ahn join ahn.alumno a where a.codigoAlumno = :s1")
	public List<AlumnoHasNotas>verNotas(@Param("s1") int alumno);
	
	@Query("select ahn from AlumnoHasNotas ahn join ahn.alumno a join ahn.asignatura asi where a.codigoAlumno = :s1"
			+ " and asi.codigoAsignatura = :s2")
	public AlumnoHasNotas verNotasXCurso(@Param("s1") int alumno,@Param("s2") int asignatura);
	
	
	
	
}
