package es.laguna.teams.Repositories;

import es.laguna.teams.Models.Player;
import es.laguna.teams.Models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    Staff findByName(String name);
}
