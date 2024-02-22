package es.laguna.teams.dtos.UserDto;

import es.laguna.teams.Models.user.Role;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Builder
public class UserRequestDto {
    private final String firstname;
    private final String lastname;
    private final String email;
    private final String password;
}
