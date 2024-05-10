package com.turkcell.springSecurity.business.abstracts;

import com.turkcell.springSecurity.entities.concretes.RefreshToken;
import com.turkcell.springSecurity.entities.concretes.User;

public interface RefreshTokenService {
    RefreshToken create(User user);
    RefreshToken verifyRefreshToken(String token);
}
