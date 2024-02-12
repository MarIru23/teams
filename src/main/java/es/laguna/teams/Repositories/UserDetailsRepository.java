package es.laguna.teams.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import es.laguna.teams.Models.user.User;
//El de arriba importalo a mano

public interface UserDetailsRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
