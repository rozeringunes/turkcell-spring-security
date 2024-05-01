package com.turkcell.springSecurity.dataAccess.abstracts;


import com.turkcell.springSecurity.entities.concretes.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Integer> {
}
