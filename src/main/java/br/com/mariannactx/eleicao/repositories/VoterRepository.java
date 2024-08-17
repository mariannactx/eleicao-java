package br.com.mariannactx.eleicao.repositories;

import org.springframework.data.repository.ListCrudRepository;

import br.com.mariannactx.eleicao.models.Voter;

public interface VoterRepository extends ListCrudRepository<Voter, Long> {
  
}
