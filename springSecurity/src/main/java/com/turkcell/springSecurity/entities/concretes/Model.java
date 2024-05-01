package com.turkcell.springSecurity.entities.concretes;

import com.turkcell.springSecurity.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="models")
public class Model extends BaseEntity<Integer> {
    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name="brandId")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name="fuelId")
    private Fuel fuel;

    @ManyToOne
    @JoinColumn(name ="transmissionId")
    private Transmission transmission;

    @OneToMany(mappedBy = "model")
    private List<Car>car;
}
