package br.com.mariannactx.eleicao.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mariannactx.eleicao.models.Voter;
import br.com.mariannactx.eleicao.services.VoterService;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Tag(name="Eleitores")
@RestController
@RequestMapping("eleitores")
public class VoterController {
  private final VoterService voterService;
  
  public VoterController(VoterService voterService) {
    this.voterService = voterService;
  }

  @GetMapping("criar")
  public Voter create() {
      return voterService.create();
  }

  @GetMapping
  public List<Voter> read() {
      return voterService.list();
  }

  @DeleteMapping("{id}")
  public String delete(@PathVariable Long id) {
    return voterService.delete(id);
  }

  
}
