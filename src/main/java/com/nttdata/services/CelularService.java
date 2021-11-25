package com.nttdata.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Celular;
import com.nttdata.repositories.CelularRepository;

@Service
public class CelularService {
	
	@Autowired
	CelularRepository celularRepository;

	public void insertarCelular(@Valid Celular celular) {
		celularRepository.save(celular);
		
	}
	

}
