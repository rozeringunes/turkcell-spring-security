package com.turkcell.springSecurity.business.dto.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginRequest {
    @NotNull
    private String email;
    @NotNull
    private String password;
}
