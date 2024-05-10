package com.turkcell.springSecurity.business.concretes;

import com.turkcell.springSecurity.business.abstracts.AuthService;
import com.turkcell.springSecurity.business.abstracts.RefreshTokenService;
import com.turkcell.springSecurity.business.abstracts.UserService;
import com.turkcell.springSecurity.business.dto.requests.LoginRequest;
import com.turkcell.springSecurity.business.messages.AuthMessages;
import com.turkcell.springSecurity.core.services.JwtService;
import com.turkcell.springSecurity.core.utilities.exceptions.types.BusinessException;
import com.turkcell.springSecurity.entities.concretes.RefreshToken;
import com.turkcell.springSecurity.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class AuthManager implements AuthService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;

    @Override
    public String login(LoginRequest request) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        if (!authentication.isAuthenticated()) throw new BusinessException(AuthMessages.LOGIN_FAILED);

        User user= userService.findByUsername(request.getEmail());
        String jwt=generateJwt(user);
        //TODO:Create Refresh Token For Specific USER
        refreshTokenService.create(user);
        return jwt;
    }
    @Override
    public String refreshToken(String refreshToken) {
        //TODO:RefreshToken-User
        RefreshToken token= refreshTokenService.verifyRefreshToken(refreshToken);
        User user =token.getUser();
        return generateJwt(user);
    }
    private String generateJwt(User user){
        Map<String,Object> claims =new HashMap<>();
        claims.put("username",user.getUsername());
        claims.put("id",user.getId());
        return jwtService.generateToken(claims,user.getEmail());

    }
}
