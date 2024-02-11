package es.laguna.teams.Repositories;

import es.laguna.teams.Models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
//El repository es siempre una interfaz, la siguiente linea es asi, te guste o no
public interface TeamRepository extends JpaRepository<Team, Long>{
    Optional<Team> findTeamByUuid(UUID uuid);
}
