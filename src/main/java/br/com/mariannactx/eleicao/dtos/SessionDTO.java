package br.com.mariannactx.eleicao.dtos;

import jakarta.validation.constraints.NotBlank;

public record SessionDTO(@NotBlank Long role_id) {

}
