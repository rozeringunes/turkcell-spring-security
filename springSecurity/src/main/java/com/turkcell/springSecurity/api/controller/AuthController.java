package com.turkcell.springSecurity.api.controller;

import com.turkcell.springSecurity.business.abstracts.AuthService;
import com.turkcell.springSecurity.business.dto.requests.LoginRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private AuthService authService;

    @PostMapping("/login")
    private String login(@RequestBody LoginRequest request){
        return authService.login(request);
    }
    @PostMapping("/refresh")
    public String refreshToken(@RequestBody String refreshToken){
        return authService.refreshToken(refreshToken);
    }
}
