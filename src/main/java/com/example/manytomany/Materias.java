package com.example.manytomany;

import jakarta.persistence.*;

@Entity
@Table(name = "materias")
public class Materias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreMat;
    private String credit;

    public Materias() {
    }

    public Materias(String nombreMat, String credit) {
        this.nombreMat = nombreMat;
        this.credit = credit;
    }

    public Long getId() {
        return id;
    }

    public Materias setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNombreMat() {
        return nombreMat;
    }

    public Materias setNombreMat(String nombreMat) {
        this.nombreMat = nombreMat;
        return this;
    }

    public String getCredit() {
        return credit;
    }

    public Materias setCredit(String credit) {
        this.credit = credit;
        return this;
    }

    @Override
    public String toString() {
        return "Materias{" +
                "id=" + id +
                ", nombreMat='" + nombreMat + '\'' +
                ", credit='" + credit + '\'' +
                '}';
    }
}