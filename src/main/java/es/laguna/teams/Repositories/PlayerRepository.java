package es.laguna.teams.Repositories;

import es.lagunaga.com.Models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findTeamByUuid(UUID uuid);
    List<Player> findByNumber(Integer number);
    Player findByName(String name);

}

// Optional es cuando tiene variable que la diferencie con las otras que es unica mientra con un list es cuando por ejemplos los jugadores tienen los mismo nombres y quieres que se te devuelvan los que tengan ese nombre
