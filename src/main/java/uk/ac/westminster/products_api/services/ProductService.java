package uk.ac.westminster.products_api.services;

import org.springframework.stereotype.Service;
import uk.ac.westminster.products_api.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    public List<Product> getAllProducts() {
        return products;
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public Product saveProduct(Product product) {
        product.setId(nextId);
        nextId += 1L;
        products.add(product);
        System.out.println("Product added successfully");
        return product;
    }

    public String deleteProduct(Long id) {
        boolean isDeleted = products.removeIf(p -> p.getId().equals(id));

        if (isDeleted) {
            return "Product deleted successfully";
        } else {
            return "Product ID not found";
        }
    }
}
