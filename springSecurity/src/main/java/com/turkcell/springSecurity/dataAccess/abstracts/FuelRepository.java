package com.turkcell.springSecurity.dataAccess.abstracts;

import com.turkcell.springSecurity.entities.concretes.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelRepository extends JpaRepository<Fuel,Integer> {
}
