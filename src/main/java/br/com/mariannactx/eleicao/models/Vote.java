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

}
