package br.com.mariannactx.eleicao.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mariannactx.eleicao.dtos.CandidateDTO;
import br.com.mariannactx.eleicao.models.Candidate;
import br.com.mariannactx.eleicao.services.CandidateService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Tag(name="Candidatos")
@RestController
@RequestMapping("candidatos")
public class CandidateController {
  private final CandidateService candidateService;
  
  public CandidateController(CandidateService candidateService) {
    this.candidateService = candidateService;
  }

  @PostMapping
  public Candidate create(@RequestBody CandidateDTO data) {
      return candidateService.create(data);
  }

  @GetMapping
  public List<Candidate> read() {
      return candidateService.list();
  }

  @PatchMapping("{id}")
  public Candidate update(@PathVariable Long id, @RequestBody @Valid CandidateDTO data) {
      
      return candidateService.update(id, data);
  }

  @DeleteMapping("{id}")
  public String delete(@PathVariable Long id) {
    return candidateService.delete(id);
  }
  
}
