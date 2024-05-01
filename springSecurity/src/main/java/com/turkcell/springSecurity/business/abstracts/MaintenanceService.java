package com.turkcell.springSecurity.business.abstracts;

import com.turkcell.springSecurity.business.dto.requests.CreateMaintenanceRequest;
import com.turkcell.springSecurity.business.dto.responses.CreatedMaintenanceResponse;

public interface MaintenanceService {
    CreatedMaintenanceResponse add(CreateMaintenanceRequest createMaintenanceRequest);
}
