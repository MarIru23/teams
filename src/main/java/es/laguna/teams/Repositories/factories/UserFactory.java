package es.laguna.teams.Repositories.factories;

import es.laguna.teams.Models.user.User;
import es.laguna.teams.Repositories.UserDetailsRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/factory")
public class UserFactory {
    private final UserDetailsRepository userDetailsRepository;

    @Autowired
    public UserFactory(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @PostMapping("/users")
    public void init() {
        Faker faker = new Faker();
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User(
                    faker.internet().emailAddress(),
                    faker.internet().password()
            );
            userList.add(user);
        }
        userDetailsRepository.saveAll(userList);
    }
}
