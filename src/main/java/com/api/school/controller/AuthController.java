package com.api.school.controller;

import com.api.school.dto.auth.AuthDto;
import com.api.school.dto.auth.LoginDto;
import com.api.school.dto.auth.RegisterDto;
import com.api.school.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;


    @PostMapping(value = "/login")
    public ResponseEntity<AuthDto> login(@RequestBody LoginDto loginDto) {
        AuthDto authDto = authService.login(loginDto);
        return ResponseEntity.ok(authDto);
    }

    @PostMapping("/register")
    public ResponseEntity<AuthDto> register(@RequestBody RegisterDto registerDto) {
        AuthDto authDto = authService.register(registerDto);
        return ResponseEntity.ok(authDto);
    }
}
