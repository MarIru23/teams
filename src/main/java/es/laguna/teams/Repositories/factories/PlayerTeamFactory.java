package es.laguna.teams.Repositories.factories;

import es.laguna.teams.Models.Player;
import es.laguna.teams.Models.Team;
import es.laguna.teams.Repositories.PlayerRepository;
import es.laguna.teams.Repositories.TeamRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/factory")
public class PlayerTeamFactory {
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public PlayerTeamFactory(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    @PostMapping("/people")
    public void init() {
        Faker faker = new Faker();
        for (int i = 0; i < 5; i++) {
            List<Player> playerList = new ArrayList<>();
            Team team = new Team(
                    null,
                    UUID.randomUUID(),
                    faker.team().name(),
                    faker.address().country(),
                    faker.color().hex(),
                    null
            );
            teamRepository.save(team);
            for (int j = 0; j < 10; j++) {
                Player player = new Player(
                        null,
                        UUID.randomUUID(),
                        faker.name().fullName(),
                        faker.number().numberBetween(1, 25),
                        team
                );
                playerList.add(player);
                playerRepository.save(player);
            }
            team.setPlayers(playerList);
            teamRepository.save(team);
        }
    }
}
