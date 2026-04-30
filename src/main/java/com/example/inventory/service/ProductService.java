package com.example.inventory.service;

import com.example.inventory.entity.Product;
import com.example.inventory.exception.*;
import com.example.inventory.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public Product addProduct(Product product) {

        if (product.getPrice() <= 0)
            throw new BadRequestException("Price must be > 0");

        if (product.getQuantity() < 0)
            throw new BadRequestException("Quantity cannot be negative");

        if (repo.findByName(product.getName()).isPresent())
            throw new BadRequestException("Duplicate product name");

        return repo.save(product);
    }

    public Product getProduct(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    public List<Product> getAll() {
        return repo.findAll();
    }

    public Product updateProduct(Long id, Product updated) {

        Product p = getProduct(id);

        if (updated.getPrice() <= 0)
            throw new BadRequestException("Price must be > 0");

        p.setName(updated.getName());
        p.setCategory(updated.getCategory());
        p.setPrice(updated.getPrice());
        p.setQuantity(updated.getQuantity());

        return repo.save(p);
    }

    public Product increaseStock(Long id, int amount) {
        Product p = getProduct(id);
        p.setQuantity(p.getQuantity() + amount);
        return repo.save(p);
    }

    public Product decreaseStock(Long id, int amount) {
        Product p = getProduct(id);

        if (p.getQuantity() - amount < 0)
            throw new BadRequestException("Stock cannot go below zero");

        p.setQuantity(p.getQuantity() - amount);
        return repo.save(p);
    }

    public List<Product> lowStock() {
        return repo.findByQuantityLessThan(5);
    }
}