package com.example.manytoone;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "vecinos")
public class Vecinos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nif;
    @ManyToOne
    private Edificio edificio;


    public Vecinos() {
    }

    public Vecinos(String name, String nif, Edificio edificio) {
        this.name = name;
        this.nif = nif;
        this.edificio = edificio;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public Vecinos setEdificio(Edificio edificio) {
        this.edificio = edificio;
        return this;
    }

    @Override
    public String toString() {
        return "Vecinos{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nif='" + nif + '\'' +
                '}';
    }
}