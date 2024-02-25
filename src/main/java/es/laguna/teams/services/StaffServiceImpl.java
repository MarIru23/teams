package es.laguna.teams.services;

import es.laguna.teams.Models.Player;
import es.laguna.teams.Models.Staff;
import es.laguna.teams.Models.Team;
import es.laguna.teams.Repositories.StaffRepository;
import es.laguna.teams.Repositories.TeamRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class StaffServiceImpl implements StaffService{
    private final TeamRepository teamRepository;
    private final StaffRepository staffRepository;

    @Autowired
    public StaffServiceImpl(TeamRepository teamRepository, StaffRepository staffRepository) {
        this.teamRepository = teamRepository;
        this.staffRepository = staffRepository;
    }

    @Override
    public List<Staff> findall() {
        return staffRepository.findAll();
    }
    @Override
    public Staff findById(Long id) {
        return staffRepository.findById(id).get();
    }

    @Override
    public Staff save(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public void deleteById(Long id) {
        staffRepository.deleteById(id);
    }

    @Override
    public Staff update(Long Id, Staff model) {
        Staff date=this.findById(Id);
        date.setName(model.getName());
        date.setRole(model.getRole());
        date.setYears(model.getYears());
        //Se guarda el nuevo cambio en el nuevo team ya actualizado
        return staffRepository.save(date);
    }

    @Override
    public Staff findByName(String name) {
        List<Staff> staffs = staffRepository.findByName(name);
        if (staffs != null && !staffs.isEmpty()) {
            return staffs.get(0);
        } else {
            return null;
        }
    }
    @Override
    @Transactional
    public List<Staff> deleteStaffByYearsLessThanEqual(Integer years) {
        List<Staff> staffs = staffRepository.deleteStaffByYearsLessThanEqual(years);
        return staffs;
    }

    @Override
    @Transactional
    public List<Staff> findByNameStartingWith(String letter) {
        List<Staff> staffs = staffRepository.findByNameStartingWith(letter);
        return staffs;
    }
}


