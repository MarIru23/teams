package es.laguna.teams.Mappers;

import es.laguna.teams.Models.user.User;
import es.laguna.teams.dtos.UserDto.UserRequestDto;
import es.laguna.teams.dtos.UserDto.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDto toResponse(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail()
        );
    }

    public User toModel(UserRequestDto userDTO) {
        return new User(
                null,
                userDTO.getFirstname(),
                userDTO.getLastname(),
                userDTO.getEmail(),
                userDTO.getPassword()
        );
    }
}
