package es.laguna.teams.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlayerRequestDto {
    private final String name;
    private final Integer number;
    private final Long Team_id;
}
