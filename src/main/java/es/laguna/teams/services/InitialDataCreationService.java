package es.laguna.teams.services;
import es.laguna.teams.Models.Player;
import es.laguna.teams.Models.Team;
import es.laguna.teams.Models.user.User;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class InitialDataCreationService {
    private final TeamService teamService;
    private final PlayerService playerService;
    private final UserDetailServiceImpl userDetailsService;
    private final Faker faker = new Faker(new Locale("en-US"));

    public void createDefaultAdminUser() {
        User user = new User("user", "$2a$12$K4tojeaYWMK55KzWzDWtLOuuUjRTkycWhSGHYWA2LXMZqmZUtuXPO"); // Esto es "password" codificado con bcrypt)
        userDetailsService.save(user);
    }

    public void createFakerTeam(int number) {
        if(number <= 0) return;
        for (int i = 0; i < number; i++) {

            Team team = new Team(
                    null,
                    UUID.randomUUID(),
                    faker.commerce().department(),
                    faker.lorem().characters(10, 40),
                    faker.color().hex(),
                    null
            );
            teamService.save(team);
        }
    }
    public void createFakeProducts(int number) {
        if(number <= 0) return;
        List<Team> teams = teamService.findall();

        for (int i = 0; i < number; i++) {
            int teamIndex = faker.number().numberBetween(0, teams.size());
            Team team = teams.get(teamIndex);
            Player player = new Player(
                    null,
                    UUID.randomUUID(),
                    faker.commerce().productName(),
                    faker.number().numberBetween(1, 25),
                    team
            );
            playerService.save(player);
        }
    }
}
