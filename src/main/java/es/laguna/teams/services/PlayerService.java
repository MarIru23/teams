package es.laguna.teams.services;

import es.laguna.teams.Models.Player;

import java.util.List;

public interface PlayerService {
    //Retorna todos por eso es lista
    List<Player> findall();
    //Busca por Id
    Player findByPlayerId(Long id);
    //Es el de crear un jugador
    Player save(Player player);
    //El de eliminar jugador
    void deleteById(Long id);
    // busca por nombre de jugador
    //Actualiza jugador y esto puede ser model o cualquier otro nombre es solo el nombre que se le da
    Player update(Long Id, Player model);
    Player findByName(String name);

    Player findByNumber(Integer number);

    Player patch(Long id, Player player);
    
}
