package com.clientes.one.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClientesRecordDto(@NotBlank String nome,@NotNull String Telefone,@NotNull String email) {

}
