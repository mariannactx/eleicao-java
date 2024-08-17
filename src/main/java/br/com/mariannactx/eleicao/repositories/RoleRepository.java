package br.com.mariannactx.eleicao.repositories;

import org.springframework.data.repository.ListCrudRepository;

import br.com.mariannactx.eleicao.models.Role;

public interface RoleRepository extends ListCrudRepository<Role, Long> {
  
  boolean existsByName(String name);
}
