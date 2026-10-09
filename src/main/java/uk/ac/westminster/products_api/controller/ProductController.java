package uk.ac.westminster.products_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import uk.ac.westminster.products_api.Product;
import java.util.ArrayList;

@RestController
@RequestMapping("/products")
public class ProductController {
    ArrayList<Product> products = new ArrayList<>();

    public ProductController() {
        products.add(new Product(1L, "Laptop", 999.99));
        products.add(new Product(2L, "Mouse", 19.99));
        products.add(new Product(3L, "Keyboard", 59.99));
    }

    @GetMapping
    public ArrayList<Product> getAllProducts() {
            return products;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found");
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
            products.add(product);
            return product;
    }
}
