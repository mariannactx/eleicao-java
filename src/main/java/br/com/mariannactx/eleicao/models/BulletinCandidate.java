package br.com.mariannactx.eleicao.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BulletinCandidate {
  private Long id;
  private String name;
  private Long votes;

  public BulletinCandidate(Long id, String name, Long votes){
    this.id = id;
    this.name = name;
    this.votes = votes;
  }
}
