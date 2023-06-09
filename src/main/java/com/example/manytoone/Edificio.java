package com.example.manytoone;

import jakarta.persistence.*;

@Entity
@Table(name = "edificio")
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer numero;
    private String portero;


    public Edificio() {
    }

    public Edificio(String nombre, Integer numero, String portero) {
        this.nombre = nombre;
        this.numero = numero;
        this.portero = portero;

    }

    public Long getId() {
        return id;
    }

    public Edificio setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Edificio setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Integer getNumero() {
        return numero;
    }

    public Edificio setNumero(Integer numero) {
        this.numero = numero;
        return this;
    }

    public String getPortero() {
        return portero;
    }

    public Edificio setPortero(String portero) {
        this.portero = portero;
        return this;
    }



    @Override
    public String toString() {
        return "Edificio{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", numero=" + numero +
                ", portero='" + portero + '\'' +
                '}';
    }
}