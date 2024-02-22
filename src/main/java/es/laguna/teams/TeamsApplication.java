package es.laguna.teams;

import es.laguna.teams.services.InitialDataCreationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TeamsApplication {

	public static void main(String[] args) {
		System.out.println("Comenzando");
		SpringApplication.run(TeamsApplication.class, args);
	}
	@Bean
	public CommandLineRunner init(InitialDataCreationService service) {
		return args -> {
			service.createDefaultAdminUser();
			service.createFakerTeam(10);
			service.createFakePlayer(100);
		};
	}
}
