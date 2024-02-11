package es.laguna.teams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TeamsApplication {

	public static void main(String[] args) {
		System.out.println("Comenzando");
		SpringApplication.run(TeamsApplication.class, args);
	}

}
