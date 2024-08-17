package br.com.mariannactx.eleicao.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mariannactx.eleicao.dtos.RoleDTO;
import br.com.mariannactx.eleicao.models.Role;
import br.com.mariannactx.eleicao.services.RoleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Tag(name="Cargos")
@RestController
@RequestMapping("cargos")
public class RoleController {
  private final RoleService roleService;
  
  public RoleController(RoleService roleService) {
    this.roleService = roleService;
  }

  @PostMapping
  public Role create(@RequestBody RoleDTO data) {
      return roleService.create(data);
  }

  @GetMapping
  public List<Role> read() {
      return roleService.list();
  }

  @PatchMapping("{id}")
  public Role update(@PathVariable Long id, @RequestBody @Valid RoleDTO data) {
      
      return roleService.update(id, data);
  }

  @DeleteMapping("{id}")
  public String delete(@PathVariable Long id) {
    return roleService.delete(id);
  }
  
  
}
