package es.laguna.teams.services;

import es.laguna.teams.Models.Team;
import es.laguna.teams.Repositories.PlayerRepository;
import es.laguna.teams.Repositories.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//estos dos se ponen para que te para utilizar el autowired
@Service
@Slf4j
public class TeamServiceImpl implements TeamService{
    //Esto se pone siempre para conectar mas tarde el service con el controller
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }
    //Esto se te genera solo por que extiende se lo que has puesto en teamservice
    @Override
    public List<Team> findall() {
        return teamRepository.findAll();
    }

    //Siempre que busque un elemento y te lo retorne hay que poner obligatoria mente orElseThrow para que no te de error
    @Override
    public Team findById(Long id) {
        return teamRepository.findById(id).get();
    }

    @Override
    public Team save(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public void deletebyId(Long id) {
        teamRepository.deleteById(id);
    }

    @Override
    public Team update(Long Id, Team model) {
        Team date=this.findById(Id);
        date.setName(model.getName());
        date.setColor(model.getColor());
        date.setCountry(model.getCountry());
        //Se guarda el nuevo cambio en el nuevo team ya actualizado
        return teamRepository.save(date);
    }
}
