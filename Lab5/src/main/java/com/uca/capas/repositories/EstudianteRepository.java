package com.uca.capas.repositories;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uca.capas.domain.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer>{
	
	public List <Estudiante> findBynombre(String cadena) throws DataAccessException;
	
	public List <Estudiante> findByApellidoStartingWith(String cadena) throws DataAccessException;
	
	@Query(nativeQuery=true, value="SELECT * FROM public.estudiante ORDER BY estudiante.id_estudiante ASC")
	public List<Estudiante> mostrarTodos() throws DataAccessException;
	
	//@Query(nativeQuery=true, value="Select * from public.estudiante where nombre = :cadena")
	@Query(nativeQuery=true, value="Select * from public.estudiante where nombre = ?1")
	public List<Estudiante> mostrarporNombre(String cadena) throws DataAccessException;
	
	@Query(nativeQuery=true, value="select nombre, apellido from public.estudiante")
	public List<Object[]> pruebaDTO() throws DataAccessException;
}
