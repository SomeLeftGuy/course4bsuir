package com.example.coursework.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.coursework.model.dto.JwtAuthenticationResponseDTO;
import com.example.coursework.model.dto.AuthorizationEmployeeDTO;
import com.example.coursework.model.dto.RegistrationEmployeeDTO;
import com.example.coursework.service.AuthenticationService;

@RestController
@RequestMapping(value = "/api/v1/auth", produces = "application/json")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

    @Operation(summary = "Регистрация пользователя")
    @PostMapping("/sign-up")
    public Integer signUp(@RequestBody RegistrationEmployeeDTO request) {
        return authenticationService.signUp(request);
    }

    @Operation(summary = "Авторизация пользователя")
    @PostMapping("/sign-in")
    public JwtAuthenticationResponseDTO signIn(@RequestBody AuthorizationEmployeeDTO request) {
        return authenticationService.signIn(request);
    }
}

