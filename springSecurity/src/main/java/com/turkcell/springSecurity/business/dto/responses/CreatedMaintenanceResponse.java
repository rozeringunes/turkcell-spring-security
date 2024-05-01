package com.turkcell.springSecurity.business.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedMaintenanceResponse {
    private int id;
    private int carId;
    private LocalDateTime createdDate;
}
