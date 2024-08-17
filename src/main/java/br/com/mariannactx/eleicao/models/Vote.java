package br.com.mariannactx.eleicao.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "votes")
public class Vote {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @NotBlank
  @ManyToOne
  @JoinColumn(name="voter_id", referencedColumnName = "id", nullable = false)
  private Voter voter;

  @NotBlank
  @ManyToOne
  @JoinColumn(name="candidate_id", referencedColumnName = "id", nullable = false)
  private Candidate candidate;

  @NotBlank
  @ManyToOne
  @JoinColumn(name="session_id", referencedColumnName = "id", nullable = false)
  private Session session;

  public Vote(Long voter_id, Long candidate_id, Long session_id){
    Voter voter = new Voter();
    voter.setId(voter_id);

    Candidate candidate = new Candidate();
    candidate.setId(candidate_id);

    Session session = new Session();
    session.setId(session_id);

    this.voter = voter;
    this.candidate = candidate;
    this.session = session;
  }
}
