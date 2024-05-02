package com.turkcell.springSecurity.business.concretes;

import com.turkcell.springSecurity.business.abstracts.AuthService;
import com.turkcell.springSecurity.business.abstracts.UserService;
import com.turkcell.springSecurity.core.services.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthManager implements AuthService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public String login() {
        return "";
    }
}
