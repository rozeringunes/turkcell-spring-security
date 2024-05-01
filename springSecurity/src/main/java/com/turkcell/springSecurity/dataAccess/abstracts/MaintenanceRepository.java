package com.turkcell.springSecurity.dataAccess.abstracts;

import com.turkcell.springSecurity.entities.concretes.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRepository extends JpaRepository<Maintenance,Integer> {
}
