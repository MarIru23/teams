package es.laguna.teams.Services;

import es.laguna.teams.Models.Team;

import java.util.List;

public interface TeamService {
    List<Team> findAll();

    //Busca por id
    Team findById(Long id);

    //Busca

    //Crear equipo
    Team save(Team team);

    //Eliminar equipo
    void deleteById(Long id);

    //Actualizar equipo, y el model es solo el nombre que se le da, puede ser cualquier nombre
    Team update(Long id, Team model);


}
