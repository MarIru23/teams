package es.laguna.teams;

import es.laguna.teams.services.InitialDataCreationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class TeamsApplication {
	public static void main(String[] args) {
		SpringApplication.run(TeamsApplication.class, args);
		Scanner scanner = new Scanner(System.in);

		printWelcomeMessage();

		System.out.print("\nPor favor, ingresa tu nombre: ");
		String nombreUsuario = scanner.nextLine();

		System.out.println("\nHola, " + nombreUsuario + "! Gracias por usar nuestra aplicación.");
		System.out.println("Aqui puedes ver los equipos de nuestra liga: http://localhost:8080/api/teams");
		System.out.println("Aqui puedes ver los jugadores de nuestra liga: http://localhost:8080/api/players");
		System.out.println("Aqui el staff que componen loas equipos: http://localhost:8080/api/staffs");


	}

	private static void printWelcomeMessage() {

		System.out.println("*******************************************************************************************************************");
		System.out.println("*                                                                                                                 *");
		System.out.println("*                                                                                                                 *");
		System.out.println("*                                                  ¡BIENVENIDO!                                                   *");
		System.out.println("*                                      Este es el sistema para ver el futbol                                      *");
		System.out.println("*                                                                                                                 *");
		System.out.println("*                                                                                                                 *");
		System.out.println("*******************************************************************************************************************");
	}

	@Bean
	public CommandLineRunner init(InitialDataCreationService service) {
		return args -> {
			service.createDefaultAdminUser();
			service.createFakerTeam(7);
			service.createFakerPlayer(70);
			service.createFakerStaff(30);
		};
	}
}
