package com.turkcell.springSecurity.entities.concretes;

import com.turkcell.springSecurity.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="brands")
public class Car extends BaseEntity<Integer> {
    @Column(name="modelYear")
    private String modelYear;
    @Column(name="plate")
    private String plate;
    @Column(name="state")
    private int state;
    @Column(name="dailyPrice")
    private double dailyPrice;

    @ManyToOne
    @JoinColumn(name="model_id")
    private Model model;

    @OneToMany(mappedBy = "car")
    private List<Maintenance>maintenances;


}
