package es.laguna.teams.controllers;

import es.laguna.teams.auth.JWTService;
import es.laguna.teams.auth.LogInRequest;
import es.laguna.teams.auth.SignUpRequest;
import es.laguna.teams.services.UserDetailServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class authcontroller {
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailServiceImpl userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<Map>login(@RequestBody LogInRequest loginRequest) {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                ));
        return ResponseEntity.ok(Map.of("token",
                jwtService.createToken(authentication.getName()
                ))
        );
    }
    @PostMapping("/signup")
    public ResponseEntity<UserDetails> signup(@RequestBody SignUpRequest signupRequest) {
        return ResponseEntity.ok(
//                jwtService.createToken(authentication.getName())
                userDetailsService.create(signupRequest) //pasar por mapper
        );
    }
}
