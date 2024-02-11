package es.laguna.teams.Services;

import es.laguna.teams.Models.Player;

import java.util.List;

public interface PlayerService {

    List<Player> findAll();

    //Busca por id
    Player findById(Long id);

    //Busca por nombre
    Player findByName(String name);

    //Crear jugador
    Player save(Player player);

    //Eliminar jugador
    void deleteById(Long id);

    //Actualizar jugador, y el model es solo el nombre que se le da, puede ser cualquier nombre
    Player update(Long id, Player model);

    Player patch(Long id, Player player);
}
