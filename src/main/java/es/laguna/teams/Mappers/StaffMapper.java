package es.laguna.teams.Mappers;

import es.laguna.teams.Models.Player;
import es.laguna.teams.Models.Staff;
import es.laguna.teams.dtos.PlayerRequestDto;
import es.laguna.teams.dtos.PlayerResponseDto;
import es.laguna.teams.dtos.StaffRequestDto;
import es.laguna.teams.dtos.StaffResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Component
public class StaffMapper {
    //Inicializa el team mapper y generas ek contructor y ya lo mimos
    private final TeamMapper teamMapper;

    //Constructor por defecto, autowired hay que ponerlo
    @Autowired
    public StaffMapper(TeamMapper teamMapper) {
        this.teamMapper = teamMapper;
    }
    public StaffResponseDto toResponse(Staff staff) {
        if (staff != null) {
            return new StaffResponseDto(
                    staff.getId(),
                    staff.getUuid(),
                    staff.getName(),
                    staff.getRole(),
                    staff.getYears(),
                    staff.getTeam()
            );
        } else {
            return null;
        }
    }
    //Se pone simpre por que le herredas
    public List<StaffResponseDto> toResponse(List<Staff> staffs) {
        return staffs.stream()
                .map(this::toResponse)
                .filter(Objects::nonNull)
                .toList();
    }

    //Se importa el de request
    public Staff toModel(StaffRequestDto staffRequestDto){
        return new Staff(
                0L,
                UUID.randomUUID(),
                staffRequestDto.getName(),
                staffRequestDto.getRole(),
                staffRequestDto.getYears(),
                staffRequestDto.getTeam_id() != null ?
                        teamMapper.toModelfromRequestDto(staffRequestDto.getTeam_id()) : null

        );
    }
}
