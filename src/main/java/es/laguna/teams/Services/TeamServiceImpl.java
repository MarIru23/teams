package es.laguna.teams.Services;

import es.laguna.teams.Models.Team;
import es.laguna.teams.Repositories.PlayerRepository;
import es.laguna.teams.Repositories.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//Estos dos tambien tienes que escribirlos a mano, sino no te deja el autowired
@Service
@Slf4j

//Tiene que implementar de la service normal, pero invocas el repository
public class TeamServiceImpl implements TeamService {


    //Estas dos lineas hay que ponerlas a mano tanto de player como de team
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }


    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }


    //Or else throw cuando te podria devolver un null
    @Override
    public Team findById(Long id) {
        return teamRepository.findById(id).orElseThrow();
    }

    @Override
    public Team save(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public void deleteById(Long id) {
        teamRepository.deleteById(id);
    }


    //Creas un objeto llamado update que va a ser el id que le pases y actualizas sus datos
    @Override
    public Team update(Long id, Team model) {
        Team updated =this.findById(id);

        updated.setName(model.getName());
        updated.setCountry(model.getCountry());
        updated.setColor(model.getColor());

        return teamRepository.save(updated);
    }
}
