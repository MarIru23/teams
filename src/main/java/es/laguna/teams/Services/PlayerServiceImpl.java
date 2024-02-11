package es.laguna.teams.Services;

import es.laguna.teams.Models.Player;
import es.laguna.teams.Repositories.PlayerRepository;
import es.laguna.teams.Repositories.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j

//Se implementa el service, pero lo que se invoca luego es el repository
public class PlayerServiceImpl implements PlayerService{

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;


    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public Player findById(Long id) {
        return playerRepository.findById(id).orElseThrow();
    }

    @Override
    public Player findByName(String name) { return playerRepository.findByName(name); }

    @Override
    public Player save(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public void deleteById(Long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public Player update(Long id, Player model) {
        Player updated =this.findById(id);

        updated.setName(model.getName());
        updated.setNumber(model.getNumber());
        updated.setTeam(model.getTeam());

        return playerRepository.save(updated);
    }

    @Override
    public Player patch(Long id, Player player) {
        Player playerToPatch = playerRepository.findById(id).orElseThrow();

        if(player.getName() != null) {
            playerToPatch.setName(player.getName());
        }
        if(player.getNumber() != null) {
            playerToPatch.setNumber(player.getNumber());
        }
        if(player.getTeam() != null) {
            playerToPatch.setTeam(player.getTeam());
        }

        return playerRepository.save(playerToPatch);
    }
}
