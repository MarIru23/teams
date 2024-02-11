package es.laguna.teams.Mappers;

import es.laguna.teams.Models.Team;
import es.laguna.teams.dtos.TeamRequestDto;
import es.laguna.teams.dtos.TeamResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

//Component importalo q sino la lias, el orden importa
@Component
public class TeamMapper {

    public TeamResponseDto toResponse(Team team){
        return new TeamResponseDto(
            team.getId(),
            team.getUuid(),
            team.getName(),
            team.getCountry(),
            team.getColor(),
            team.getPlayers()

        );
    }

    public List<TeamResponseDto> toResponse(List<Team> teams) {
        return teams.stream()
                .map(this::toResponse)
                .toList();
    }


    //Le pasas un equipo como parametro y te lo inicializa
    public Team toModel(TeamRequestDto teamRequestDto) {
        return new Team(
                0L,
                UUID.randomUUID(),
                teamRequestDto.getName(),
                teamRequestDto.getCountry(),
                teamRequestDto.getColor(),
                null
        );
    }

    //Este se pasa null menos el id, que se pasa como parametro
    public Team toModelfromRequestDto(Long teamId) {
        return new Team(
                teamId,
                null,
                null,
                null,
                null,
                null
        );
    }




}
