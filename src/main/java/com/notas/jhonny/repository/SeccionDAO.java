package com.notas.jhonny.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.notas.jhonny.entity.Seccion;

public interface SeccionDAO extends JpaRepository<Seccion, Integer> {
	
	@Query("select s from Seccion s where s.codigoSeccion = :s1")
	public Seccion buscarSeccion(@Param("s1") int seccion);

}
