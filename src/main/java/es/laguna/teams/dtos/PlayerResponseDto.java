package es.laguna.teams.dtos;
import es.laguna.teams.Models.Team;
import lombok.Data;

import java.util.UUID;

@Data

public class PlayerResponseDto {
    private final Long id;
    private final UUID uuid;
    private final String name;
    private final Integer number;
    private final Team team;
}
