package es.laguna.teams.services;

import es.laguna.teams.Models.Player;
import es.laguna.teams.Models.Team;

import java.util.List;

public interface TeamService {
    //Retorna todos por eso es lista
    List<Team>findall();
    //Busca por Id
    Team findById(Long id);

    Team findTeamByName(String name);

    //Es el de crear un equipo
    Team save(Team team);
    //El de eliminar equipo
    void deletebyId(Long id);

    //Actualiza equipo y esto puede ser model o cualquier otro nombre es solo el nombre que se le da
    Team update(Long Id, Team model);

    Team patch(Long id, Team team);
}
