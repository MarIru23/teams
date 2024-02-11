package es.laguna.teams.dtos;

import es.laguna.teams.Models.Player;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class TeamResponseDto {
//En el response se ponen a final todos los atributos
    private final Long Id;
    private final UUID uuid;
    private final String name;
    private final String country;
    private final String color;
    private final List<Player> players;

}
