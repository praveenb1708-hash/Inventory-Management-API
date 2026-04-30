package com.example.inventory.controller;

import com.example.inventory.entity.Product;
import com.example.inventory.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public Product add(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable Long id) {
        return service.getProduct(id);
    }

    @GetMapping
    public List<Product> all() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        return service.updateProduct(id, product);
    }

    @PatchMapping("/{id}/increase")
    public Product increase(@PathVariable Long id, @RequestParam int amount) {
        return service.increaseStock(id, amount);
    }

    @PatchMapping("/{id}/decrease")
    public Product decrease(@PathVariable Long id, @RequestParam int amount) {
        return service.decreaseStock(id, amount);
    }

    @GetMapping("/low-stock")
    public List<Product> lowStock() {
        return service.lowStock();
    }
}