package com.turkcell.springSecurity.business.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterRequest {
    private String email;
    private String password;
    private LocalDate birthDate;

}
