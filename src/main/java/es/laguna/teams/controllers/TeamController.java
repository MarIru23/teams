package es.laguna.teams.controllers;

import es.laguna.teams.Mappers.TeamMapper;
import es.laguna.teams.Models.Team;
import es.laguna.teams.dtos.TeamRequestDto;
import es.laguna.teams.dtos.TeamResponseDto;
import es.laguna.teams.services.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
@Slf4j
public class TeamController {
    private final TeamMapper teamMapper;
    private final TeamService teamService;

    @Autowired
    public TeamController(TeamMapper teamMapper, TeamService teamService) {
        this.teamMapper = teamMapper;
        this.teamService = teamService;
    }

    @GetMapping("")
    public ResponseEntity<List<TeamResponseDto>> getAllTeam(
          //  @Nullable @RequestParam String searchteam
    ) {
        log.info("getallTeams");
      //  if(searchteam != null && !searchteam.isEmpty()){
     //       return ResponseEntity.of(
      //              teamMapper.toResponse(teamService.findall(searchteam))
      //      );
      //  }
        return ResponseEntity.ok(
                teamMapper.toResponse(teamService.findall())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamResponseDto> getTeamById(
            @PathVariable Long id
    ) {
        log.info("getTeamById");
        return ResponseEntity.ok(
                teamMapper.toResponse(teamService.findById(id))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TeamResponseDto> deleteTeam(
          @PathVariable Long id
    ){
        log.info("deleteTeam");
        teamService.deletebyId(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<TeamResponseDto> insertteam(
            @RequestBody TeamRequestDto teamRequestDto
            ){
        log.info("insertTeam");
        Team productSaved = teamService.save(teamMapper.toModel(teamRequestDto));
        return ResponseEntity.created(null).body(
                teamMapper.toResponse(productSaved)
        );
    }


}
