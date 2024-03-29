package com.example.CrudProductModule.controllers;

import com.example.CrudProductModule.models.Product;
import com.example.CrudProductModule.models.Provider;
import com.example.CrudProductModule.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Controlador para manejar las solicitudes y responder con plantillas en HTML
@Controller
public class ProductController {
    @Autowired
    public ProductService productService;

    // Obtener todos los productos de la base de datos
    @GetMapping("/products")
    public String homeProduct(Model model) {
        List<Product> allProducts = productService.getAllProducts();
        model.addAttribute("allProducts", allProducts);
        return "home";
    }

    // Obtener la vista del formulario para añadir un producto
    @GetMapping("/products/add")
    public String formSaveProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        List<Provider> getAllProviders = productService.getAllProviders();
        model.addAttribute("providers", getAllProviders);

        System.out.println("Contenido del modelo: " + model);

        return "views/form";
    }


    // Se utiliza para manejar solicitudes POST a la ruta "/products/add"
    @PostMapping("/products/add")
    public String saveProduct(@Valid Product product, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            for (FieldError error : bindingResult.getFieldErrors()){
                System.out.println(error);
            }
            model.addAttribute("providers", productService.getAllProviders());
            return "views/form";
        }
        productService.saveProduct(product);
        return "redirect:/products";
    }

    // Metodo para obtener la vista del formulario de edicion de un producto
    @GetMapping("/products/edit/{id}")
    public String updateProduct(@PathVariable Long id, Model model) {

        Optional<Product> productOptional = productService.findProductById(id);

        if (productOptional.isPresent()) {
            Product product = productOptional.get(); // Obtiene el producto del Optional si está presente
            model.addAttribute("product", product);
            return "edit-form";
        } else {
            return "redirect:/error";
        }
    }

    // Actualiza y guarda un producto que ya es editado
    @PostMapping("/products/update")
    public String updateAndSaveProduct(@ModelAttribute Product product) {
        productService.updateProduct(product);
        return "redirect:/products";
    }


    // Maneja la parte de eliminar un producto por medio de su ID
    @PostMapping("/products/{id}")
    public String deleteProduct(@PathVariable Long id){

        System.out.println(id);
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
