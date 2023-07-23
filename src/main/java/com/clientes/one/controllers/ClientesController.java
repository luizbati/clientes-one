package com.clientes.one.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clientes.one.dtos.ClientesRecordDto;
import com.clientes.one.models.ClientesModel;
import com.clientes.one.repositories.ClientesRepository;

import jakarta.validation.Valid;

@RestController
public class ClientesController {
	
	@Autowired
	ClientesRepository clientesRepository;
	
	
	@PostMapping("/clientes")
	public ResponseEntity<ClientesModel>saveClientes(@RequestBody @Valid ClientesRecordDto clientesRecordDto){
		var clientesModel = new ClientesModel();
		BeanUtils.copyProperties(clientesRecordDto, clientesModel);		
		return ResponseEntity.status(HttpStatus.CREATED).body(clientesRepository.save(clientesModel));
	}

}
