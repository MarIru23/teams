package es.laguna.teams.services;

import es.laguna.teams.Models.Team;
import net.datafaker.providers.food.Tea;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface TeamService {
    //Retorna todos por eso es lista
    List<Team>findall();
    //Busca por Id
    Team findById(Long id);

    Team findTeamByName(String name);


    Team findTeamByUuid(UUID uuid);

    List<Team> findByChampions(Boolean champions);

    //Es el de crear un equipo
    Team save(Team team);
    //El de eliminar equipo
    void deletebyId(Long id);

    //Actualiza equipo y esto puede ser model o cualquier otro nombre es solo el nombre que se le da
    Team update(Long Id, Team model);

    Team patch(Long id, Team team);

    Team setChampions(Long id, Boolean champions, LocalDateTime tochampionsTimestamp);
}
