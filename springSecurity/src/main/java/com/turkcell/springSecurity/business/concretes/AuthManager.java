package com.turkcell.springSecurity.business.concretes;

import com.turkcell.springSecurity.business.abstracts.AuthService;
import com.turkcell.springSecurity.business.abstracts.UserService;
import com.turkcell.springSecurity.business.dto.requests.LoginRequest;
import com.turkcell.springSecurity.business.messages.AuthMessages;
import com.turkcell.springSecurity.core.services.JwtService;
import com.turkcell.springSecurity.core.utilities.exceptions.types.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
    public String login(LoginRequest request) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        if (!authentication.isAuthenticated()) throw new BusinessException(AuthMessages.LOGIN_FAILED);
        String jwt = jwtService.generateToken(request.getEmail());
        return jwt;


    }
}
