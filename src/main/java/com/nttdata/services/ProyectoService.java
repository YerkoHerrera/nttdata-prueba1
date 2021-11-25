package com.nttdata.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Proyecto;
import com.nttdata.repositories.ProyectoRepository;

@Service
public class ProyectoService {
	@Autowired
	ProyectoRepository proyectoRepository;
	
	public void insertarProyecto(@Valid Proyecto proyecto) {
		proyectoRepository.save(proyecto);
	}

	public Object obtenerListaProyectos() {
		return proyectoRepository.findAll();
	}

	public Proyecto buscarProyecto(Long id) {
		return proyectoRepository.findById(id).get();
	}
	
	public void eliminarProyecto(Long id) {
		proyectoRepository.deleteById(id);
		
	}

	public void eliminarProyectoObjeto(Proyecto proyecto) {
		proyectoRepository.delete(proyecto);
		
	}

	public void updateProyecto(@Valid Proyecto proyecto) {
		if(proyectoRepository.existsById(proyecto.getId())){
			proyectoRepository.save(proyecto);
		}		
	}

	
}
