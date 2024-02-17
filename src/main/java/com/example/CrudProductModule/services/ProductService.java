package com.example.CrudProductModule.services;

import com.example.CrudProductModule.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    // Método para obtener todos los productos.
    List<Product> getAllProducts();

    // Método para buscar un producto por su ID.
    Optional<Product> findProductById(Long id);

    // Método para guardar un nuevo producto en la base de datos.
    void saveProduct(Product product);

    // Metodo para actualizar un producto ya existente.
    void updateProduct(Product product);

    // Metodo para eliminar un producto por medio de su ID de la base de datos.
    void deleteProduct(Long id);
}
