package com.nttdata.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nttdata.models.Proyecto;

public interface ProyectoRepository extends CrudRepository<Proyecto, Long> {
	List<Proyecto> findAll();

}
