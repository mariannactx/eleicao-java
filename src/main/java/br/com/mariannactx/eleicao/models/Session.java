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
@Table(name = "sessions")
public class Session {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Column(nullable = false)
  private int status = 1;

  @NotBlank
  @ManyToOne
  @JoinColumn(name="role_id", referencedColumnName = "id", nullable = false)
  private Role role;

  public Session() {}
  
  public Session(Long role_id) {
    Role role = new Role();
    role.setId(role_id);

    this.role = role;
  }

  public void close() {
    this.status = 0;
  }

}
