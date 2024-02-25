package es.laguna.teams.controllers;

import es.laguna.teams.Mappers.PlayerMapper;
import es.laguna.teams.Mappers.StaffMapper;
import es.laguna.teams.dtos.PlayerResponseDto;
import es.laguna.teams.dtos.StaffResponseDto;
import es.laguna.teams.services.PlayerService;
import es.laguna.teams.services.StaffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/staffs")
@Slf4j
public class StaffController {
    private final StaffMapper staffMapper;
    private final StaffService staffService;

    @Autowired
    public StaffController(StaffMapper staffMapper, StaffService staffService) {
        this.staffMapper = staffMapper;
        this.staffService = staffService;
    }
    @GetMapping("")
    public ResponseEntity<List<StaffResponseDto>> getAllStaff(){
        log.info("getAllPlayer");
        return ResponseEntity.ok(
                staffMapper.toResponse(staffService.findall())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StaffResponseDto> getByID(@PathVariable Long id){
        log.info("getByID");
        return ResponseEntity.ok(
                staffMapper.toResponse(staffService.findById(id))
        );
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<StaffResponseDto> getByName(@PathVariable String name){
        log.info("getName");
        return ResponseEntity.ok(
                staffMapper.toResponse(staffService.findByName(name))
        );
    }

}
