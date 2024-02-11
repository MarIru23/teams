package es.laguna.teams.controllers;

import es.laguna.teams.Mappers.PlayerMapper;
import es.laguna.teams.Models.Player;
import es.laguna.teams.Services.PlayerService;
import es.laguna.teams.dtos.PlayerRequestDto;
import es.laguna.teams.dtos.PlayerResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
@Slf4j
public class PlayerController {

    private final PlayerService playerService;
    private final PlayerMapper playerMapper;

    @Autowired
    public PlayerController(PlayerService playerService, PlayerMapper playerMapper) {
        this.playerService = playerService;
        this.playerMapper = playerMapper;
    }

    @GetMapping("")
    public ResponseEntity<List<PlayerResponseDto>> getAllPlayers(){
        log.info("getAllPlayers");
        return ResponseEntity.ok(
                playerMapper.toResponse(playerService.findAll())
        );
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<PlayerResponseDto> getPlayerById(
            @PathVariable Long id
    ){
        log.info("getPlayerById");
        return ResponseEntity.ok(
                playerMapper.toResponse(playerService.findById(id))
        );
    }

    @GetMapping("/byName/{name}")
    public ResponseEntity<PlayerResponseDto> getPlayerByName(
            @PathVariable String name
    ){
        log.info("getPlayerByName");
        return ResponseEntity.ok(
                playerMapper.toResponse(playerService.findByName(name))
        );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<PlayerResponseDto> deleteById(
            @PathVariable Long id
    ){
        log.info("deletePlayerById");
        playerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //save
    @PostMapping
    public ResponseEntity<PlayerResponseDto> postPlayer(
            @RequestBody PlayerRequestDto playerRequestDto
    ) {
        log.info("addPlayer");
        Player playerSaved = playerService.save(playerMapper.toModel(playerRequestDto));
        return ResponseEntity.created(null).body(
                playerMapper.toResponse(playerSaved)
        );
    }

    //update
    @PutMapping("/{id}")
    public ResponseEntity<PlayerResponseDto> putPlayer(
            @PathVariable Long id,
            @RequestBody PlayerRequestDto playerRequestDto
    ) {
        log.info("putPlayer");
        Player playerUpdated = playerService.update(id, playerMapper.toModel(playerRequestDto));
        return ResponseEntity.ok(
                playerMapper.toResponse(playerUpdated)
        );
    }


    @PatchMapping("/patch/{id}")
    public ResponseEntity<PlayerResponseDto> patchPlayer(
            @PathVariable Long id,
            @RequestBody PlayerRequestDto playerRequestDto
    ) {
        log.info("patchGeneralPlayer");

        Player playerPatched = playerService.patch(id, playerMapper.toModel(playerRequestDto));

        return ResponseEntity.ok(playerMapper.toResponse(playerPatched));
    }

}
