package es.laguna.teams.Repositories;

import es.laguna.teams.Models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
//Optional cuando solo es un uuid, y List es para atributos que pueden repetirse
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findPlayerByUuid(UUID uuid);
    List<Player> findByNumber(Integer number);
    Player findByName(String name);

}
