package com.turkcell.springSecurity.core.services;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public interface SecurityService {
    HttpSecurity configureSecurity(HttpSecurity http) throws Exception;
}
