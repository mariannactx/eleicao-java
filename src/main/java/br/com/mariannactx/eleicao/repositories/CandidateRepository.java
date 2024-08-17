package br.com.mariannactx.eleicao.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import br.com.mariannactx.eleicao.models.Candidate;

public interface CandidateRepository extends ListCrudRepository<Candidate, Long> {
   
  @Query(value = "SELECT COUNT(*) FROM candidates WHERE role_id = :id", nativeQuery = true)
  int countByRole_id(Long id);

}
