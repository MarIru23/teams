package es.laguna.teams.dtos;

import lombok.Data;

@Data
public class TeamRequestDto {
//En el request se ponen solo aquellos que se pasan como parámetro
    private final String name;
    private final String country;
    private final String color;

}
