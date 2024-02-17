package com.example.CrudProductModule.services;

import com.example.CrudProductModule.models.Product;
import com.example.CrudProductModule.models.Provider;
import com.example.CrudProductModule.repository.ProductRepository;
import com.example.CrudProductModule.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceImpl implements ProductService {

    @Autowired
    public ProductRepository productRepository;

    @Autowired
    public ProviderRepository providerRepository;

    // Método para obtener todos los productos.
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    //Metodo para obtener todos los proovedores que ya se encuentran registrados en la DB
    public List<Provider> getAllProviders() {return (List<Provider>) providerRepository.findAll();}

    // Método para obtener un producto por su ID
    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    // Método para guardar un producto nuevo.
    public void saveProduct(@RequestBody Product product) {
        productRepository.save(product);
    }

    // Método para actualizar un producto ya existente.
    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    // Metodo para eliminar un producto existente por su ID.
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
