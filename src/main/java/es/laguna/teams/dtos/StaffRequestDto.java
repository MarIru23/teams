package es.laguna.teams.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StaffRequestDto {
    private final String name;
    private final Integer number;
    private final String role;
    private final Integer years;
    private final Long Team_id;
}
