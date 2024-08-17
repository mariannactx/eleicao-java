package br.com.mariannactx.eleicao.views;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.mariannactx.eleicao.models.BulletinCandidate;
import br.com.mariannactx.eleicao.models.Session;

public class Bulletin {
  public static String generate(Session session, List<BulletinCandidate> bulletinCandidates){
    String bulletin = "";
  
    String datetime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

    bulletin += "----------------------------------------\n";
    bulletin += "Data relatório:" + String.format("%25s", datetime) + "\n";
    bulletin += "\n";
    bulletin += "Cargo:" + String.format("%34s",session.getRole().getName()) + "\n";
    bulletin += "\n";
    Long total = Long.valueOf(0);
    for(BulletinCandidate candidate : bulletinCandidates){
      Long votes = candidate.getVotes();
      String name = candidate.getName();
      bulletin += name + String.format("%" + (40 - name.length()) + "d", votes) + "\n";
      total = total + votes;
    }

    BulletinCandidate winner = bulletinCandidates.get(0);

    bulletin += "\n";
    bulletin += "Total de votos" + String.format("%26d", total) + "\n";
    bulletin += "\n";
    bulletin += "Vencedor:" + String.format("%" + (40 - winner.getName().length()) + "s", winner.getName()) + "\n";
    bulletin += "----------------------------------------";


    return bulletin;

  }
}
