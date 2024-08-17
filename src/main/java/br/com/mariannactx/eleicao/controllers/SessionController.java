package br.com.mariannactx.eleicao.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mariannactx.eleicao.dtos.SessionDTO;
import br.com.mariannactx.eleicao.models.Session;
import br.com.mariannactx.eleicao.services.SessionService;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Tag(name="Sessões")
@RestController
@RequestMapping("")
public class SessionController {
  private final SessionService sessionService;
  
  public SessionController(SessionService sessionService) {
    this.sessionService = sessionService;
  }

  @GetMapping("sessoes")
  public List<Session> read() {
      return sessionService.list();
  }
  
  @PostMapping("abrir-sessao")
  public Session open(@RequestBody SessionDTO data) {
      return sessionService.create(data);
  }

  @PatchMapping("fechar-sessao/{id}")
  public Session close(@PathVariable Long id) {
      
      return sessionService.close(id);
  }
}
