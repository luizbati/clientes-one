package com.clientes.one.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/clientes")
	public ResponseEntity<List<ClientesModel>>getAllClientes(){
		return ResponseEntity.status(HttpStatus.OK).body(clientesRepository.findAll());
	}
	
	@GetMapping("/clientes/{id}")
	public ResponseEntity<Object>getOneCliente(@PathVariable(value="id")UUID id,@RequestBody @Valid ClientesRecordDto clientesRecordDto){
		Optional<ClientesModel>clientesO = clientesRepository.findById(id);
		if(clientesO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
		}
		return ResponseEntity.status(HttpStatus.OK).body(clientesO.get());
		}
		
	@PutMapping("/products/{id}")
    public ResponseEntity<Object>updateClientes(@PathVariable(value="id")UUID id,@RequestBody @Valid ClientesRecordDto clientesRecordDto){
            Optional<ClientesModel>clientesO = clientesRepository.findById(id);
            if(clientesO.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
            }
            var clientesModel = clientesO.get();
            BeanUtils.copyProperties(clientesRecordDto,clientesModel);
            return ResponseEntity.status(HttpStatus.OK).body(clientesRepository.save(clientesModel));
	}
}
