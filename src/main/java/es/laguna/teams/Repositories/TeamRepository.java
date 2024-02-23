package es.laguna.teams.Repositories;

import es.laguna.teams.Models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//El repositori siempre es una interfaz
@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{
    Optional<Team> findTeamByUuid(UUID uuid);

    Optional<Team> findTeamByName(String name);

    List<Team> findByChampions(boolean champions);

}
