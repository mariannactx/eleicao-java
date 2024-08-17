package br.com.mariannactx.eleicao.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.mariannactx.eleicao.dtos.VoteDTO;
import br.com.mariannactx.eleicao.models.BulletinCandidate;
import br.com.mariannactx.eleicao.models.Vote;
import br.com.mariannactx.eleicao.repositories.SessionRepository;
import br.com.mariannactx.eleicao.repositories.VoteRepository;
import br.com.mariannactx.eleicao.repositories.VoterRepository;

@Service
public class VoteService {
  private final VoteRepository voteRepository;
  private final SessionRepository sessionRepository;
  private final VoterRepository voterRepository;
  
  public VoteService(VoteRepository voteRepository, SessionRepository sessionRepository, VoterRepository voterRepository) {
    this.voteRepository = voteRepository;
    this.sessionRepository = sessionRepository;
    this.voterRepository = voterRepository;
  }

  public Vote create(Long voter_id, VoteDTO data) {
    Vote vote = new Vote(voter_id, data.candidate_id(), data.session_id());

    if(!sessionRepository.isOpenById(data.session_id())) {
      throw new RuntimeException(("Sessão está fechada"));
    }
    
    if(voterRepository.votedBySession_id(voter_id, data.session_id())) {
      throw new RuntimeException(("Eleitor já votou nessa sessão"));
    }

    return voteRepository.save(vote);
  }

  public List<BulletinCandidate> getVotesByCandidate(Long session_id) {
    return voteRepository.findBySessionGroupedByCandidate(session_id);
  }

}
