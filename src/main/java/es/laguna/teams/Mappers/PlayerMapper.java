package es.laguna.teams.Mappers;

import es.laguna.teams.Models.Player;
import es.laguna.teams.dtos.PlayerRequestDto;
import es.laguna.teams.dtos.PlayerResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Component
public class PlayerMapper {
    //Inicializa el team mapper y generas ek contructor y ya lo mimos
    private final TeamMapper teamMapper;

    //Constructor por defecto, autowired hay que ponerlo
    @Autowired
    public PlayerMapper(TeamMapper teamMapper) {
        this.teamMapper = teamMapper;
    }


    //Esto es para un put es decir update
    public PlayerResponseDto toResponse(Player player) {
        if (player != null) {
            return new PlayerResponseDto(
                    player.getId(),
                    player.getUuid(),
                    player.getName(),
                    player.getNumber(),
                    player.getTeam()
            );
        } else {
            return null;
        }
    }
    //Se pone simpre por que le herredas
    public List<PlayerResponseDto> toResponse(List<Player> players) {
        return players.stream()
                .map(this::toResponse)
                .filter(Objects::nonNull)
                .toList();
    }

    //Se importa el de request
    public Player toModel(PlayerRequestDto playerRequestDto){
        return new Player(
                0L,
                UUID.randomUUID(),
                playerRequestDto.getName(),
                playerRequestDto.getNumber(),
                playerRequestDto.getTeam_id() != null ?
                        teamMapper.toModelfromRequestDto(playerRequestDto.getTeam_id()) : null

        );
    }


}



