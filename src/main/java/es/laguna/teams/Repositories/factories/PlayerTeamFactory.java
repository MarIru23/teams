package es.laguna.teams.Repositories.factories;

import es.laguna.teams.Models.Player;
import es.laguna.teams.Models.Team;
import es.laguna.teams.Repositories.PlayerRepository;
import es.laguna.teams.Repositories.TeamRepository;
import jakarta.annotation.PostConstruct;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class PlayerTeamFactory {
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public PlayerTeamFactory(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    @PostConstruct
    public void init(){
        try {
            Faker faker = new Faker(new Locale("es"));
            for (int i = 0; i < 5; i++) {
                List<Player> playerList = new ArrayList<>();
                Team team = new Team(
                        null,
                        UUID.randomUUID(),
                        faker.commerce().department(),
                        faker.lorem().characters(10, 40),
                        faker.color().hex(),
                        null
                );
                teamRepository.save(team);
                for (int j = 0; j < 10; j++) {
                    Player player = new Player(
                            null,
                            UUID.randomUUID(),
                            faker.commerce().productName(),
                            faker.number().numberBetween(1, 25),
                            team
                    );
                    playerList.add(player);
                    playerRepository.save(player);
                }
                team.setPlayers(playerList);
                teamRepository.save(team);
            }
        } catch (Exception e){
            log.info(e.getMessage());
        }
    }
}
}
