package es.laguna.teams.Mappers;

import es.laguna.teams.Models.Team;
import es.laguna.teams.dtos.TeamRequestDto;
import es.laguna.teams.dtos.TeamResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

//El orden importa y tambien las vatiables que tienes puestas en el responseDto
@Component
public class TeamMapper {
    public TeamResponseDto toResponse(Team team) {
        return new TeamResponseDto(
                team.getId(),
                team.getUuid(),
                team.getName(),
                team.getCountry(),
                team.getStadium(),
                team.getPlayers()
        );
    }
    //Esto es siempre lo mismo
        public List<TeamResponseDto> toResponse(List<Team> teams) {
            return teams.stream()
                    .map(this::toResponse)
                    .toList();
        }
   // te coge todos los elementos pero esta vez del request por eso no estan todos
    public Team toModel(TeamRequestDto teamRequestDto) {
        return new Team(
                0L,
                UUID.randomUUID(),
                teamRequestDto.getName(),
                teamRequestDto.getCountry(),
                teamRequestDto.getStadium(),
                null
        );
    }

    // esto se pone all null menos el id se pasa como parametro
    public Team toModelfromRequestDto(Long team_Id) {
        return new Team(
                team_Id,
                null,
                null,
                null,
                null,
                null
        );
    }
}

