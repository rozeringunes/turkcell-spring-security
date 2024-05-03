package com.turkcell.springSecurity.business.abstracts;

import com.turkcell.springSecurity.business.dto.requests.LoginRequest;

public interface AuthService {
    String login(LoginRequest request);
}
