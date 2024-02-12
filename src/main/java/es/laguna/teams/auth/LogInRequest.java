package es.laguna.teams.auth;

import lombok.Data;

@Data
public class LogInRequest {
    private String email;
    private String password;
}
