package es.laguna.teams.Repositories.factories;
import es.laguna.teams.Models.user.User;
import es.laguna.teams.Repositories.UserDetailsRepository;
import jakarta.annotation.PostConstruct;

import jakarta.persistence.Column;
import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@Slf4j
public class UserFactory {

    private final UserDetailsRepository userDetailsRepository;

    @Autowired
    public UserFactory( UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @PostConstruct
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