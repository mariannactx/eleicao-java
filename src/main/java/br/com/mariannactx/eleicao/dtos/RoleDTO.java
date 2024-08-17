package br.com.mariannactx.eleicao.dtos;

import jakarta.validation.constraints.NotBlank;

public record RoleDTO(@NotBlank String name) {

}
