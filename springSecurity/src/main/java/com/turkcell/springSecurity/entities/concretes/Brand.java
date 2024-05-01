package com.turkcell.springSecurity.entities.concretes;

import com.turkcell.springSecurity.core.entities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="brands")
public class Brand extends BaseEntity<Integer> {
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<Model>models;

}
