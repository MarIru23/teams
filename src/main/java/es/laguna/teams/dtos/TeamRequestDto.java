package es.laguna.teams.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
//Aqui solo se inicializan los valores que se dan en el data.sql
public class TeamRequestDto {
    private final String name;
    private final String country;
    private final String stadium;
}
