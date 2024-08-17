package br.com.mariannactx.eleicao.services;

import br.com.mariannactx.eleicao.models.Voter;
import br.com.mariannactx.eleicao.repositories.VoterRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class VoterService {
  private final VoterRepository voterRepository;
  
  public VoterService(VoterRepository voterRepository) {
    this.voterRepository = voterRepository;
  }

  public Voter create() {
    return voterRepository.save(new Voter());
  }

  public List<Voter> list() {
    return voterRepository.findAll();
  }

  public String delete(Long id) {
    voterRepository.deleteById(id);
    
    return "";
  }
}