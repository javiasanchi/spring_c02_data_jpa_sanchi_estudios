package com.example.onetoone;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String calle;
    private String localidad;
    private String ciudad;
    private String pais;
    private Integer cp;

    public Address() {
    }

    public Address(String calle, String localidad, String ciudad, String pais, Integer cp) {
        this.calle = calle;
        this.localidad = localidad;
        this.ciudad = ciudad;
        this.pais = pais;
        this.cp = cp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", localidad='" + localidad + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", pais='" + pais + '\'' +
                ", cp='" + cp + '\'' +
                '}';
    }
}