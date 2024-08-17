package br.com.mariannactx.eleicao.models;

import org.springframework.beans.BeanUtils;

import br.com.mariannactx.eleicao.dtos.CandidateDTO;
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
@Table(name = "candidates")
public class Candidate {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Column(nullable = false)
  private String name;

  @NotBlank
  @ManyToOne
  @JoinColumn(name="role_id", referencedColumnName = "id", nullable = false)
  private Role role;
  
  public Candidate() {}
  
  public Candidate(String name, Long role_id) {
    this.name = name;
    
    Role role = new Role();
    role.setId(role_id);

    this.role = role;
  }

  public void copyProperties(CandidateDTO data) {
    BeanUtils.copyProperties(data, this);

    Role role = new Role();
    role.setId(data.role_id());

    this.role = role;

  }
}
