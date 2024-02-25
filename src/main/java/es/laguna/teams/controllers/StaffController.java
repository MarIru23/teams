package es.laguna.teams.controllers;

import es.laguna.teams.Mappers.PlayerMapper;
import es.laguna.teams.Mappers.StaffMapper;
import es.laguna.teams.Models.Staff;
import es.laguna.teams.Models.Team;
import es.laguna.teams.dtos.*;
import es.laguna.teams.services.PlayerService;
import es.laguna.teams.services.StaffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<StaffResponseDto> postStaff(@RequestBody StaffRequestDto staffRequestDto){
        log.info("insertStaff");
        Staff staffSaved = staffService.save(staffMapper.toModel(staffRequestDto));
        return ResponseEntity.created(null).body(
                staffMapper.toResponse(staffSaved)
        );
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<StaffResponseDto> deleteStaff(
            @PathVariable Long id
    ){
        log.info("deleteStaff");
        staffService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //Borrar menores que cierta edad
    @DeleteMapping("/deleteByYear/years")
    public ResponseEntity<List<StaffResponseDto>> deleteStaffByYearsLessThanEqual(
            @RequestParam Integer years //Request
    ){
        log.info("deleteStaffByYears");
        return ResponseEntity.ok(
                staffMapper.toResponse(staffService.deleteStaffByYearsLessThanEqual(years))
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<StaffResponseDto> putStaff(
            @PathVariable Long id,
            @RequestBody StaffRequestDto staffRequestDto
    ){
        log.info("putStaff");
        Staff cambioStaff =staffService
                .update(id, staffMapper.toModel(staffRequestDto));
        return ResponseEntity.ok(
                staffMapper.toResponse(cambioStaff)
        );
    }


}
