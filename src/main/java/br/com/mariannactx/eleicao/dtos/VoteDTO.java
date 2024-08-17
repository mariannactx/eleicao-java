package br.com.mariannactx.eleicao.dtos;

import jakarta.validation.constraints.NotBlank;

public record VoteDTO(
  @NotBlank Long candidate_id,
  @NotBlank Long session_id
) {

}
