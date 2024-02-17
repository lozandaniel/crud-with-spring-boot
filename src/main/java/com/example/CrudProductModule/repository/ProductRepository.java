package com.example.CrudProductModule.repository;

import com.example.CrudProductModule.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Esta interfaz define y extiende CrudRepository para manejar metodos CRUD con la base de datos.
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
