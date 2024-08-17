package br.com.mariannactx.eleicao.dtos;

import jakarta.validation.constraints.NotBlank;

public record CandidateDTO(
  @NotBlank String name, 
  @NotBlank Long role_id
) {

}
