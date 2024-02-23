package es.laguna.teams.controllers;


import es.laguna.teams.Mappers.PlayerMapper;
import es.laguna.teams.Models.Player;
import es.laguna.teams.dtos.PlayerRequestDto;
import es.laguna.teams.dtos.PlayerResponseDto;
import es.laguna.teams.services.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
@Slf4j
public class PlayerController {
    private final PlayerMapper playerMapper;
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerMapper playerMapper, PlayerService playerService) {
        this.playerMapper = playerMapper;
        this.playerService = playerService;
    }
    @GetMapping("")
    public ResponseEntity<List<PlayerResponseDto>> getAllPlayer(){
        log.info("getAllPlayer");
        return ResponseEntity.ok(
                playerMapper.toResponse(playerService.findall())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerResponseDto> getByID(@PathVariable Long id){
        log.info("getByID");
        return ResponseEntity.ok(
                playerMapper.toResponse(playerService.findByPlayerId(id))
        );
    }
    @GetMapping("/number/{number}")
    public ResponseEntity<PlayerResponseDto> getByNumber(
            @PathVariable Integer number
    ){
        log.info("getByNumber");
        return ResponseEntity.ok(
                playerMapper.toResponse(playerService.findByNumber(number))
        );
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PlayerResponseDto> getByName(
            @PathVariable String name
    ){
        log.info("getByName");
        return ResponseEntity.ok(
                playerMapper.toResponse(playerService.findByName(name))
        );
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<PlayerResponseDto> DeletebyId(
            @PathVariable Long id
    ){
        log.info("DeletebyId");
        playerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/MaxDorsal")
    public ResponseEntity<List<PlayerResponseDto>> getMaxDorsal(
            @RequestParam Integer MaxDorsal
    ) {
        log.info("getMaxDorsal");

        if (MaxDorsal < 0) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(
                playerMapper.toResponse(playerService.findByNumberGreaterThanEqual(MaxDorsal))
        );
    }


    @PutMapping("/{id}")
    public ResponseEntity<PlayerResponseDto> putPlayer(
            @PathVariable Long id,
            @RequestBody PlayerRequestDto playerRequestDto
    ){
        log.info("putPlayer");
        Player cambioPlayer =playerService
                .update(id, playerMapper.toModel(playerRequestDto));
        return ResponseEntity.ok(
                playerMapper.toResponse(cambioPlayer)
        );
    }

    @PatchMapping("/patch/{id}")
    public ResponseEntity<PlayerResponseDto> patchProduct(@PathVariable Long id, @RequestBody PlayerRequestDto playerRequestDto){
        log.info("patchGeneralProduct");
        Player playerPatched = playerService.patch(id, playerMapper.toModel(playerRequestDto));
        return ResponseEntity.ok(
                playerMapper.toResponse(playerPatched)
        );
    }
}
