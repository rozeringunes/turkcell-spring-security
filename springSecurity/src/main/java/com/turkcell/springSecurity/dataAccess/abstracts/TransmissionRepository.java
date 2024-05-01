package com.turkcell.springSecurity.dataAccess.abstracts;

import com.turkcell.springSecurity.entities.concretes.Transmission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransmissionRepository extends JpaRepository<Transmission,Integer> {
}
