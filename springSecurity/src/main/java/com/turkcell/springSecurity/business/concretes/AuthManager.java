package com.turkcell.springSecurity.business.concretes;

import com.turkcell.springSecurity.business.abstracts.AuthService;
import com.turkcell.springSecurity.business.abstracts.UserService;
import com.turkcell.springSecurity.business.dto.requests.LoginRequest;
import com.turkcell.springSecurity.business.messages.AuthMessages;
import com.turkcell.springSecurity.core.services.JwtService;
import com.turkcell.springSecurity.core.utilities.exceptions.types.BusinessException;
import com.turkcell.springSecurity.dataAccess.abstracts.RefreshTokenRepository;
import com.turkcell.springSecurity.entities.concretes.RefreshToken;
import com.turkcell.springSecurity.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
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
    private final RefreshTokenRepository refreshTokenRepository;

    @Override
    public String login(LoginRequest request) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        if (!authentication.isAuthenticated()) throw new BusinessException(AuthMessages.LOGIN_FAILED);

        User user= userService.findByUsername(request.getEmail());
        Map<String,Object> claims =new HashMap<>();
        claims.put("username",user.getUsername());
        claims.put("id",user.getId());

        String jwt = jwtService.generateToken(claims,request.getEmail());

        //TODO:Create Refresh Token For Specific USER
        RefreshToken token=new RefreshToken();
        token.setUser(user);
        token.setToken("abc");
        token.setExpirationDate(LocalDateTime.now().plusDays(10));
        refreshTokenRepository.save(token);
        return jwt;
    }
    @Override
    public String refreshToken(String refreshToken) {
        //TODO:RefreshToken-User
        RefreshToken token=refreshTokenRepository
                .findByToken(refreshToken)
                .orElseThrow(()->new BusinessException("Refresh token not found"));

        //Tüm şartlar sağlanırsa
        if(token.getExpirationDate().isBefore(LocalDateTime.now()))
            throw new BusinessException("Refresh token expired.Please login again.");
        if(token.getRevokedDate()!=null)
            throw new BusinessException("Refresh token revoked.");

        User user =token.getUser();
        Map<String,Object> claims =new HashMap<>();
        claims.put("username",user.getUsername());
        claims.put("id",user.getId());
        String jwt = jwtService.generateToken(claims,user.getEmail());
        return jwt;
        //Refresh Token kullanıldı

        //yeni jwt üret
        //yeni jwt üret
        //eski refreh tokenı düzenle
    }
}
