package com.louveapp.backend.controller;

import com.louveapp.backend.auth.AuthenticationService;
import com.louveapp.backend.dto.LoginDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authService;
   

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        String token = authService.login(loginDTO.getEmail(), loginDTO.getSenha());
        return ResponseEntity.ok(token);
    }
}