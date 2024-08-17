package br.com.mariannactx.eleicao.services;

import br.com.mariannactx.eleicao.dtos.RoleDTO;
import br.com.mariannactx.eleicao.models.Role;
import br.com.mariannactx.eleicao.repositories.RoleRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
  private final RoleRepository roleRepository;
  
  public RoleService(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  public Role create(RoleDTO data) {
    Role role = new Role();
    BeanUtils.copyProperties(data, role);
    
    return roleRepository.save(role);
  }

  public List<Role> list() {
    return roleRepository.findAll();
  }

  public Role update(Long id, RoleDTO data) {
    Optional<Role> foundRole = roleRepository.findById(id);
    
    foundRole.orElseThrow( () -> new RuntimeException(
      "Cargo " + id + " não encontrado."
    ));

    Role role = foundRole.get();
    BeanUtils.copyProperties(data, role);

    return roleRepository.save(role);
    
  }

  public String delete(Long id) {

    roleRepository.deleteById(id);
    
    return "";
  }
}