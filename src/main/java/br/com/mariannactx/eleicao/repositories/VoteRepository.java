package br.com.mariannactx.eleicao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import br.com.mariannactx.eleicao.models.BulletinCandidate;
import br.com.mariannactx.eleicao.models.Vote;


public interface VoteRepository extends ListCrudRepository<Vote, Long> {
  
  // @Query(value = """
  // SELECT
  // new br.com.mariannactx.eleicao.models.BulletinCandidate(v.candidate.id, v.candidate.name, count(v))
  // FROM Vote v
  // WHERE v.session.id = :session_id
  // GROUP BY v.candidate.id"""
  // )

  @Query(value = """
    SELECT
      new br.com.mariannactx.eleicao.models.BulletinCandidate(
        v.candidate.id,
        v.candidate.name,
        count(v)
      )
    FROM Vote v
    WHERE v.session.id = :session_id
    GROUP BY v.candidate.id, v.candidate.name"""
  )
  public List<BulletinCandidate> findBySessionGroupedByCandidate(Long session_id);
}
