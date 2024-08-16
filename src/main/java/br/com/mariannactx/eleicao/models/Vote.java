package br.com.mariannactx.eleicao.models;

import jakarta.persistence.Column;
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
  @ManyToOne(targetEntity = Voter.class)
  @JoinColumn(name="voter_id", referencedColumnName = "id", nullable = false)
  private Long voter_id;

  @NotBlank
  @ManyToOne(targetEntity = Candidate.class)
  @JoinColumn(name="candidate_id", referencedColumnName = "id", nullable = false)
  private Long candidate_id;

  @NotBlank
  @ManyToOne(targetEntity = Session.class)
  @JoinColumn(name="session_id", referencedColumnName = "id", nullable = false)
  private Long session_id;

}
