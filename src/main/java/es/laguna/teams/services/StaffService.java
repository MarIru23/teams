package es.laguna.teams.services;

import es.laguna.teams.Models.Player;
import es.laguna.teams.Models.Staff;
import es.laguna.teams.Models.Team;

import java.util.List;

public interface StaffService {

    List<Staff> findall();

    Staff findByName(String name); //Lo que quieres que te devuelva
    Staff findById(Long id);

    Staff save(Staff staff);

    void deleteById(Long id);

    Staff update(Long Id, Staff model);

}
