package es.laguna.teams.dtos;

import es.laguna.teams.Models.Player;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
//Aqui se pone all por que esto es como el frontend y solo se inicializa las varaibles que vas a querer que se muestre es decir el models es el bakend y esto es el fronted es decir que inicializas los valores que quieres
public class TeamResponseDto {
    private final Long Id;
    private final UUID uuid;
    private final String name;
    private final String country;
    private final String stadium;
    private final Boolean champions;
    private final List<Player> players;
}
