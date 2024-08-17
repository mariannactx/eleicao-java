package br.com.mariannactx.eleicao.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import br.com.mariannactx.eleicao.models.Session;

public interface SessionRepository extends ListCrudRepository<Session, Long> {
  
  @Query(value = "SELECT new java.lang.Boolean(count(s) > 0) FROM Session s WHERE s.role.id = :role_id AND status = 1")
  boolean existsByStatusOpenByRole_id(Long role_id);
  
  @Query(value = "SELECT new java.lang.Boolean(count(s) > 0) FROM Session s WHERE s.id = :id AND status = 1")
  boolean isOpenById(Long id);
}
