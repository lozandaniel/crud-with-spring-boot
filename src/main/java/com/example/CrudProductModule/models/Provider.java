package com.example.CrudProductModule.models;

import jakarta.persistence.*;

@Entity
@Table(name = "provider")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_provider")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "identification", unique = true)
    private String identification;

    @Column(name = "direction")
    private String direction;

    @Column(name = "catalog")
    private String catalog;

    @Column(name = "city")
    private String city;

    // Constructor por defecto
    public Provider() {
    }

    // Constructor con todos los campos
    public Provider(String name, String phone, String identification, String direction, String catalog, String city) {
        this.name = name;
        this.phone = phone;
        this.identification = identification;
        this.direction = direction;
        this.catalog = catalog;
        this.city = city;
    }

    // Getters y Setters
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}


