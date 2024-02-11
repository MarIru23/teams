package es.laguna.teams.controllers;

import es.laguna.teams.Mappers.TeamMapper;
import es.laguna.teams.Services.TeamService;
import es.laguna.teams.dtos.TeamResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Esto tienes que ponerlo a mano
@RestController
@RequestMapping("/api/teams")
@Slf4j
public class TeamController {

    //Controllers descuelga de mappers y de service(es el mas bajo de todos)
    private final TeamMapper teamMapper;
    private final TeamService teamService;


    @Autowired
    public TeamController(TeamMapper teamMapper, TeamService teamService) {
        this.teamMapper = teamMapper;
        this.teamService = teamService;
    }

  /*  @GetMapping("")
    public ResponseEntity<List<TeamResponseDto>> getAllTeams(
            @RequestParam @Nullable String searchStringDescription
    ) {
        log.info("getAllTeams");
        if (searchStringDescription != null && !searchStringDescription.isEmpty()) {
            return ResponseEntity.ok(
                    teamMapper.roResponse(teamService.findAll(searchStringDescription))
            );
        }
        return ResponseEntity.ok(
            teamMapper.toResponse(teamService.findAll())
        );
    }*/

    @GetMapping("")
    public ResponseEntity<List<TeamResponseDto>> getAllTeams(
    ) {
        log.info("getAllTeams");
        return ResponseEntity.ok(
                teamMapper.toResponse(teamService.findAll())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamResponseDto> getTeamById(
            @PathVariable Long id
    ){
        log.info("getTeamById");
        return ResponseEntity.ok(
          teamMapper.toResponse(teamService.findById(id))
        );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<TeamResponseDto> deleteTeamById(
            @PathVariable Long id
    ){
        log.info("deleteTeamById");
        teamService.deleteById(id);
        return ResponseEntity.noContent().build();
    }





}
