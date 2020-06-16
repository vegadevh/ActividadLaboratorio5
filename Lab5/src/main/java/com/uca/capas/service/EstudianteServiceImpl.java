package com.uca.capas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Estudiante;
import com.uca.capas.repositories.EstudianteRepository;

@Service
public class EstudianteServiceImpl implements EstudianteService{
	
	@Autowired
	EstudianteRepository estudianteRepository;
	//EstudianteDAO estudianteDAO;

	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		return estudianteRepository.findAll();
	}

	@Override
	public Estudiante findOne(Integer code) throws DataAccessException {
		return estudianteRepository.getOne(code);
	}

	@Override
	@Transactional
	public void save(Estudiante estudiante) throws DataAccessException {
		estudianteRepository.save(estudiante);
		
	}

	@Override
	@Transactional
	public void delete(Integer codigoEstudiante) throws DataAccessException {
		estudianteRepository.deleteById(codigoEstudiante);
		
	}
	
	@Override
	public List<Estudiante> filtrarPor(String cadena) throws DataAccessException {
		return estudianteRepository.mostrarporNombre(cadena);
		//return estudianteRepository.findBynombre(cadena);
	}
	
	@Override
	public List<Estudiante> empiezaCon(String cadena) throws DataAccessException {
		return estudianteRepository.findByApellidoStartingWith(cadena);
	}
	
	
}
