package com.turkcell.springSecurity.business.dto.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCarRequest {
    @NotNull
    private int modelYear;
    @NotNull
    private String plate;
    @NotNull
    private double dailyPrice;
    @NotNull
    private int modelId;
}
