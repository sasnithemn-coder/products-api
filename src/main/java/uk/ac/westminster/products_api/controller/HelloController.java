package uk.ac.westminster.products_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.westminster.products_api.Product;

import java.time.LocalDate;

@RestController
public class HelloController {

    Product product = new Product(1, "Laptop", 999.99);

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Spring Boot!";
    }

    @GetMapping("/status")
    public String status() {
        return "API running - " + LocalDate.now().toString();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable long id) {
        return product;
    }
}
