package com.example.manytomany;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "alumnos")
public class Alumnos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String nombre;
    private LocalDate edad;
    private String ident;

    public Alumnos() {
    }

    public Alumnos(String nombre, LocalDate edad, String ident) {
        this.nombre = nombre;
        this.edad = edad;
        this.ident = ident;
    }

    public Long getId() {
        return id;
    }

    public Alumnos setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Alumnos setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public LocalDate getEdad() {
        return edad;
    }

    public Alumnos setEdad(LocalDate edad) {
        this.edad = edad;
        return this;
    }

    public String getIdent() {
        return ident;
    }

    public Alumnos setIdent(String ident) {
        this.ident = ident;
        return this;
    }

    @Override
    public String toString() {
        return "Alumnos{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", ident='" + ident + '\'' +
                '}';
    }
}