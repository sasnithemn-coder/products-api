package uk.ac.westminster.products_api.controller;

import org.springframework.web.bind.annotation.*;
import uk.ac.westminster.products_api.Product;

@RestController
public class ProductController {
    Product product = new Product();

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable long id) {
        return product;
    }

    @PostMapping("/products")
    public Product saveProduct(@RequestBody Product product) {
            System.out.println(product);
            return product;
    }
}
