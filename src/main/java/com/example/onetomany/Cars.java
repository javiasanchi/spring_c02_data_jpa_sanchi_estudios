package com.example.onetomany;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "cars")
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private Integer doors;
    private Integer cvp;

    public Cars() {
    }

    public Cars(String model, Integer doors, Integer cvp) {
        this.model = model;
        this.doors = doors;
        this.cvp = cvp;

    }

    public Long getId() {
        return id;
    }

    public Cars setId(Long id) {
        this.id = id;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Cars setModel(String model) {
        this.model = model;
        return this;
    }

    public Integer getDoors() {
        return doors;
    }

    public Cars setDoors(Integer doors) {
        this.doors = doors;
        return this;
    }

    public Integer getCvp() {
        return cvp;
    }

    public Cars setCvp(Integer cvp) {
        this.cvp = cvp;
        return this;
    }



    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", doors=" + doors +
                ", cvp=" + cvp +
                '}';
    }
}