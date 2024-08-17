package br.com.mariannactx.eleicao.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import br.com.mariannactx.eleicao.models.Voter;

public interface VoterRepository extends ListCrudRepository<Voter, Long> {
    
  @Query(value = "SELECT new java.lang.Boolean(count(v) > 0) FROM Vote v WHERE v.voter.id =:id AND v.session.id=:session_id")  
  public boolean votedBySession_id(Long id, Long session_id);
}
