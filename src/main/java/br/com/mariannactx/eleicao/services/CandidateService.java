package br.com.mariannactx.eleicao.services;

import br.com.mariannactx.eleicao.dtos.CandidateDTO;
import br.com.mariannactx.eleicao.models.Candidate;
import br.com.mariannactx.eleicao.models.Role;
import br.com.mariannactx.eleicao.repositories.CandidateRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {
  private final CandidateRepository candidateRepository;
  
  public CandidateService(CandidateRepository candidateRepository) {
    this.candidateRepository = candidateRepository;
  }

  public Candidate create(CandidateDTO data) {
    Candidate candidate = new Candidate(data.name(), data.role_id());
    return candidateRepository.save(candidate);
  }

  public List<Candidate> list() {
    return candidateRepository.findAll();
  }

  public Candidate update(Long id, CandidateDTO data) {
    Optional<Candidate> foundCandidate = candidateRepository.findById(id);
    
    foundCandidate.orElseThrow( () -> new RuntimeException(
      "Candidato " + id + " não encontrado."
    ));
  
    Candidate candidate = foundCandidate.get();
    
    candidate.copyProperties(data);
    
    return candidateRepository.save(candidate);
    
  }

  public String delete(Long id) {
    candidateRepository.deleteById(id);

    return "";
  }
}