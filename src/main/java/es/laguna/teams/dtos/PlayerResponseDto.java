package es.laguna.teams.dtos;

import es.laguna.teams.Models.Team;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;
@Data
@AllArgsConstructor
public class PlayerResponseDto {
    private final Long id;
    private final UUID uuid;
    private final String name;
    private final Integer number;
    private final Team team;
}
