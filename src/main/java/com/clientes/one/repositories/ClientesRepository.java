package com.clientes.one.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clientes.one.models.ClientesModel;

@Repository
public interface ClientesRepository extends JpaRepository<ClientesModel, UUID>{

}
