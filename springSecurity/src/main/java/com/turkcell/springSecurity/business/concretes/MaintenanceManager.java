package com.turkcell.springSecurity.business.concretes;

import com.turkcell.springSecurity.business.abstracts.MaintenanceService;
import com.turkcell.springSecurity.business.dto.requests.CreateMaintenanceRequest;
import com.turkcell.springSecurity.business.dto.responses.CreatedMaintenanceResponse;
import com.turkcell.springSecurity.core.utilities.mapping.ModelMapperService;
import com.turkcell.springSecurity.dataAccess.abstracts.MaintenanceRepository;
import com.turkcell.springSecurity.entities.concretes.Maintenance;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class MaintenanceManager implements MaintenanceService {
    private MaintenanceRepository maintenanceRepository;
    private ModelMapperService modelMapperService;

    @Override
    public CreatedMaintenanceResponse add(CreateMaintenanceRequest createMaintenanceRequest) {
        Maintenance maintenance = this.modelMapperService.forRequest().map(createMaintenanceRequest, Maintenance.class);

        maintenance.setCreatedDate(LocalDateTime.now());
        maintenance.setDateSent(LocalDateTime.now());

        Maintenance createdMaintenance = maintenanceRepository.save(maintenance);

        CreatedMaintenanceResponse createdMaintenanceResponse = this.modelMapperService.forResponse()
                .map(createdMaintenance, CreatedMaintenanceResponse.class);

        return createdMaintenanceResponse;
    }
}
