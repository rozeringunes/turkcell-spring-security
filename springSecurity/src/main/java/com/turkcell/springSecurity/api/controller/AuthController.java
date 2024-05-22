package com.turkcell.springSecurity.api.controller;

import com.turkcell.springSecurity.business.abstracts.AuthService;
import com.turkcell.springSecurity.business.dto.requests.LoginRequest;
import com.turkcell.springSecurity.business.dto.responses.LoggedInResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController extends BaseController{
    private AuthService authService;
    @Value("${jwt.refresh.key}")
    private String refreshTokenKey;
    @Value("${jwt.refresh.days}")
    private int refreshTokenExpiryDays;

    @PostMapping("/login")
    private String login(@RequestBody LoginRequest request, HttpServletResponse response) {
        Cookie httpOnlyCookie = new Cookie("refreshToken", "abc");
        httpOnlyCookie.setHttpOnly(true);
        httpOnlyCookie.setMaxAge(10 * 24 * 60 * 60);
        response.addCookie(httpOnlyCookie);
        return authService.login(request);
    }

    @PostMapping("/refresh")
    public String refreshToken(HttpServletRequest request) {
        String refreshToken = getCookie(request, "refreshToken");
        return authService.refreshToken(refreshToken);
    }

}

