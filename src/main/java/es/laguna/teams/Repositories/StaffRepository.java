package es.laguna.teams.Repositories;

import es.laguna.teams.Models.Player;
import es.laguna.teams.Models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    List<Staff> findByName(String name); //Aqui le estas diciendo que te voy a pasar una lista

    List<Staff> deleteStaffByYearsLessThanEqual(Integer years);
}
