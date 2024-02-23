package es.laguna.teams.dtos;

import es.laguna.teams.Models.Team;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class StaffResponseDto {
    private final Long id;
    private final UUID uuid;
    private final String name;
    private final String role;
    private final Integer years;
    private final Team team;
}
