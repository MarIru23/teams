package es.laguna.teams.controllers;

import es.laguna.teams.Mappers.TeamMapper;
import es.laguna.teams.Models.Player;
import es.laguna.teams.Models.Team;
import es.laguna.teams.dtos.PlayerRequestDto;
import es.laguna.teams.dtos.PlayerResponseDto;
import es.laguna.teams.dtos.TeamRequestDto;
import es.laguna.teams.dtos.TeamResponseDto;
import es.laguna.teams.services.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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
    @GetMapping("/name/{name}")
    public ResponseEntity<TeamResponseDto> findTeamByName(
            @PathVariable String name
    ){
        log.info("getName");
        return ResponseEntity.ok(
                teamMapper.toResponse(teamService.findTeamByName(name))
        );
    }
    @GetMapping("/champions/{champions}")
    public ResponseEntity<List<TeamResponseDto>> findTeamsByChampions(@PathVariable boolean champions) {
        log.info("findTeamsByChampions");
        List<TeamResponseDto> teams = teamMapper.toResponse(teamService.findByChampions(champions));
        return ResponseEntity.ok(teams);
    }

    @GetMapping("/uuid/{uuid}")
    public ResponseEntity<TeamResponseDto> findTeamByUuid(
            @PathVariable UUID uuid
    ){
        log.info("getUUID");
        return ResponseEntity.ok(
                teamMapper.toResponse(teamService.findTeamByUuid(uuid))
        );
    }

    @PostMapping
    public ResponseEntity<TeamResponseDto> postteam(
            @RequestBody TeamRequestDto teamRequestDto
            ){
        log.info("insertTeam");
        Team productSaved = teamService.save(teamMapper.toModel(teamRequestDto));
        return ResponseEntity.created(null).body(
                teamMapper.toResponse(productSaved)
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<TeamResponseDto> putPlayer(
            @PathVariable Long id,
            @RequestBody TeamRequestDto teamRequestDto
    ){
        log.info("putTeam");
        Team cambioTeam =teamService
                .update(id, teamMapper.toModel(teamRequestDto));
        return ResponseEntity.ok(
                teamMapper.toResponse(cambioTeam)
        );
    }
    @PatchMapping("/patch/{id}")
    public ResponseEntity<TeamResponseDto> patchProduct(@PathVariable Long id, @RequestBody TeamRequestDto teamRequestDto){
        log.info("patchGeneralTeam");
        Team teamPatched = teamService.patch(id, teamMapper.toModel(teamRequestDto));
        return ResponseEntity.ok(
                teamMapper.toResponse(teamPatched)
        );
    }

    @PatchMapping("/toChampions/{id}")
    public ResponseEntity<TeamResponseDto> setToChampions(
            @PathVariable Long id,
            @RequestParam Boolean champions
    ) {
        LocalDateTime tochampionsTimestamp = LocalDateTime.now();
        log.info("setChampions");
        Team teamUpdated = teamService.setChampions(id, champions, tochampionsTimestamp);
        return ResponseEntity.ok(
                teamMapper.toResponse(teamUpdated)
        );
    }
}
