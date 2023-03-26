package com.example.onetomany;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String cif;
    @OneToMany
    private List<Cars> cars = new ArrayList<>();
    public Company() {
    }

    public Company(String name, String cif) {
        this.name = name;
        this.cif = cif;
        this.cars = cars;
    }

    public Long getId() {
        return id;
    }

    public Company setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    public String getCif() {
        return cif;
    }

    public Company setCif(String cif) {
        this.cif = cif;
        return this;
    }

    public List<Cars> getCars(Cars car1) {
        return cars;
    }

    public Company setCars(List<Cars> cars) {
        this.cars = cars;
        return this;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cif='" + cif + '\'' +
                '}';
    }
}