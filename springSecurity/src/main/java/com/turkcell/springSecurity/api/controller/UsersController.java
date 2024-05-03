package com.turkcell.springSecurity.api.controller;

import com.turkcell.springSecurity.business.abstracts.UserService;
import com.turkcell.springSecurity.business.dto.requests.RegisterRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UsersController {
    private UserService userService;

    @PostMapping
    public void register(@RequestBody RegisterRequest request) {
        userService.register(request);
    }
}
