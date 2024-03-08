package com.example.CrudProductModule.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

// MODELO DE LA BASE DE DATOS TABLA DE "PRODUCT"
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_provider")
    private Provider provider;

    @Column(name = "name")
    @NotBlank(message = "El campo no puede ser vacio")
    private String name;

    @Column(name = "description")
    @NotBlank
    private String description;

    @Column(name = "category")
    @NotBlank
    private String category;

    @Column(name = "quantity")
    @Min(1)
    private int quantity;

    @Column(name = "price")
    @Min(1000)
    private int price;

    public Product() {
    }

    public Product(Long id, Provider provider, String name, String description, String category, int quantity, int price) {
        this.id = id;
        this.provider = provider;
        this.name = name;
        this.description = description;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
