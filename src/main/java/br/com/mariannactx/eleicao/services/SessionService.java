package br.com.mariannactx.eleicao.services;

import br.com.mariannactx.eleicao.dtos.SessionDTO;
import br.com.mariannactx.eleicao.models.Session;
import br.com.mariannactx.eleicao.repositories.SessionRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class SessionService {
  private final SessionRepository sessionRepository;
  
  public SessionService(SessionRepository sessionRepository) {
    this.sessionRepository = sessionRepository;
  }

  public Session create(SessionDTO data) {

    if(sessionRepository.existsByStatusOpenByRole_id(data.role_id()))
      throw new RuntimeException("Já existe sessão aberta para esse cargo.");

    Session session = new Session(data.role_id());

    return sessionRepository.save(session);
  }

  public Optional<Session> findById(Long id) {
    return sessionRepository.findById(id);
  }

  public List<Session> list() {
    return sessionRepository.findAll();
  }

  public Session close(Long id) {
    Optional<Session> foundSession = sessionRepository.findById(id);
    
    foundSession.orElseThrow( () -> new RuntimeException(
      "Sessão " + id + " não encontrada."
    ));
    
    Session session = foundSession.get();

    session.close();

    return sessionRepository.save(session);
  }
}