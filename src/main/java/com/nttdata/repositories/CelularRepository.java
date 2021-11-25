package com.nttdata.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nttdata.models.Celular;

public interface CelularRepository extends CrudRepository<Celular, Long>{
	
	List<Celular> findAll();
}
