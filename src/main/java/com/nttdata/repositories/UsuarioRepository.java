package com.nttdata.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Usuario;

//Interfaz que extiende de crudrepository, una especie de clase que añade funciones
@Repository 
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	List<Usuario> findAll();
}
