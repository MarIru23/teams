package es.laguna.teams.controllers;

import es.laguna.teams.dtos.UserDto.UserRequestDto;
import es.laguna.teams.dtos.UserDto.UserResponseDto;
import es.laguna.teams.Mappers.UserMapper;
import es.laguna.teams.services.UserDetailServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin                        // PERMITE EL INTERCAMBIO ENTRE BACKEND Y FRONTEND PUERTO DE ANGULAR
@RequiredArgsConstructor
public class UserController {
    private final UserDetailServiceImpl userService;
    private final UserMapper userMapper;

    @GetMapping("/{email}")
    public ResponseEntity<UserResponseDto> getUser(
            @PathVariable String email
    ) {
        return ResponseEntity.ok(userMapper.toResponse(userService.loadUserByUsername(email)));
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> postUser(
            @RequestBody UserRequestDto user
    ) {
        return ResponseEntity.ok(userMapper.toResponse(userService.save(userMapper.toModel(user))));
    }

    @PutMapping("/{email}")
    public ResponseEntity<UserResponseDto> updateUser(
            @PathVariable String email,
            @RequestBody UserRequestDto user
    ) {
        return ResponseEntity.ok(userMapper.toResponse(userService.updateUser(email, userMapper.toModel(user))));
    }
}
