package br.com.mariannactx.eleicao.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mariannactx.eleicao.dtos.VoteDTO;
import br.com.mariannactx.eleicao.models.BulletinCandidate;
import br.com.mariannactx.eleicao.models.Session;
import br.com.mariannactx.eleicao.models.Vote;
import br.com.mariannactx.eleicao.services.SessionService;
import br.com.mariannactx.eleicao.services.VoteService;
import br.com.mariannactx.eleicao.views.Bulletin;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Votação")
@RestController
@RequestMapping("")
public class VoteController {
  private final VoteService voteService;
  private final SessionService sessionService;

  public VoteController(VoteService voteService, SessionService sessionService) {
    this.voteService = voteService;
    this.sessionService = sessionService;
  }

  @PostMapping("eleitores/{voter_id}/votar")
  public Vote create(@PathVariable Long voter_id, @RequestBody VoteDTO data) {
      return voteService.create(voter_id, data);
  }

  @GetMapping("boletim-urna/{session_id}")
  public String bulletin(@PathVariable Long session_id) {
    Optional<Session> foundSession = sessionService.findById(session_id);
    
    foundSession.orElseThrow( () -> new RuntimeException(
      "Sessão " + session_id + " não encontrada."
    ));
  
    Session session = foundSession.get();
    List<BulletinCandidate> bulletin = voteService.getVotesByCandidate(session_id);


    return Bulletin.generate(session, bulletin);
  }

}
