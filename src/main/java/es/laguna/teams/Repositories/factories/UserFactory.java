package es.laguna.teams.Repositories.factories;
import es.laguna.teams.Models.user.User;
import es.laguna.teams.Repositories.UserDetailsRepository;
import jakarta.annotation.PostConstruct;

import jakarta.persistence.Column;
import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@Component
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserFactory {

    private final UserDetailsRepository userDetailsRepository;

    @Autowired
    public UserFactory( UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @PostMapping ("/user")
    public void init(){
        try {
            Faker faker = new Faker(new Locale("es"));
            for (int i = 0; i < 3; i++) {
                userDetailsRepository.save(
                        new User(
                                faker.internet().emailAddress(),
                                faker.internet().password()
                        )
                );
            }
        } catch (Exception e){
            log.info(e.getMessage());
        }
    }
}