package com.turkcell.springSecurity.business.abstracts;

import com.turkcell.springSecurity.business.dto.requests.RegisterRequest;
import com.turkcell.springSecurity.entities.concretes.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void register(RegisterRequest request);
    User findByUsername(String username);
}
