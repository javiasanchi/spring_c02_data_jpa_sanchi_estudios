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
    private Integer piso;
    private String puerta;
    private LocalDate fechanac;
    private String nif;
    @ManyToOne
    private Edificio edificio;


    public Vecinos() {
    }

    public Vecinos(String name, Integer piso, String puerta, String nif, LocalDate fechanac, Edificio edificio) {
        this.name = name;
        this.piso = piso;
        this.puerta = puerta;
        this.fechanac = fechanac;
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

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public String getPuerta() {
        return puerta;
    }

    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }

    public LocalDate getFechanac() {
        return fechanac;
    }

    public void setFechanac(LocalDate fechanac) {
        this.fechanac = fechanac;
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
                ", piso=" + piso +
                ", puerta='" + puerta + '\'' +
                ", fechanac=" + fechanac +
                ", nif='" + nif + '\'' +
                '}';
    }
}