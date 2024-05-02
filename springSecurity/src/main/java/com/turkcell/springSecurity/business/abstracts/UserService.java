package com.turkcell.springSecurity.business.abstracts;

import com.turkcell.springSecurity.business.dto.requests.RegisterRequest;

public interface UserService {
    void register(RegisterRequest request);
}
