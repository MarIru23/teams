package es.laguna.teams.services;

import es.laguna.teams.Models.Player;
import es.laguna.teams.Repositories.PlayerRepository;
import es.laguna.teams.Repositories.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
//Ojo siempre en el primero se implementa el service pero en lo que hay que invocar es el respository no liar!!!!
public class PlayerServiceImpl implements PlayerService {
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Player> findall() {
        return playerRepository.findAll();
    }

    @Override
    public Player findByPlayerId(Long id) {
        return playerRepository.findById(id).orElseThrow();
    }
 //   @Override
 //   public boolean findByName(String name) {
  //      return playerRepository.findByName(name).equals(name);
   // }

    @Override
    public Player save(Player player) {
        return playerRepository.save(player);
    }
    @Override
    public void deleteById(Long id) {
        playerRepository.deleteById(id);
    }



    @Override
    public Player findByName(String name) {
        return playerRepository.findByName(name);
    }

    @Override
    public Player patch(Long id, Player player) {
        Player playerToPatch = playerRepository.findById(id).orElseThrow();
        if(player.getName() != null){
            playerToPatch.setName(player.getName());
        }
        if(player.getNumber() != null){
            playerToPatch.setNumber(player.getNumber());
        }
        if(player.getTeam() != null){
            playerToPatch.setTeam(player.getTeam());
        }
        return playerRepository.save(playerToPatch);
    }

    @Override
    public Player update(Long Id, Player model) {
        Player change=this.findByPlayerId(Id);

        change.setName(model.getName());
        change.setNumber(model.getNumber());
        change.setTeam(model.getTeam());

        return playerRepository.save(change);
    }
}
