package com.notas.jhonny.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.notas.jhonny.entity.Alumno;
import com.notas.jhonny.entity.Docente;
import com.notas.jhonny.entity.Horario;

public interface DocenteDAO extends JpaRepository<Docente, Integer> {
	
	//yo como Docente dese poder iniciar sesion con mis credenciales
	@Query("select d from Docente d where d.correoDocente = :s1 and d.contraDocente = :s2")
	public Docente loginDocente(@Param("s1") String user, @Param("s2") String pass);
	
	//yo como Docente deseo ver mis horarios
	@Query("select h from AlumnoHasMatricula ahm join ahm.seccion s join ahm.alumno a "
			+ "join s.horario h join s.docente d where d.codigoDocente = :s1 ")
	public List<Horario>verHorariosXDocente(@Param("s1") int cod);
	
	
}
