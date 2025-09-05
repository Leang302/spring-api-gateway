package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

import org.example.model.Product;
import org.example.model.dto.request.ProductRequest;
import org.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductRepository productRepository;
    @Value("${server.port}")
    private String port;

    @Operation(summary = "Get product by id")
    @GetMapping("{id}")
    public Product getProductById(@PathVariable Long id) {
        System.out.println(port);
        return productRepository.findById(id).orElseThrow();
    }

    @Operation(summary = "Get all products")
    @GetMapping
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Operation(summary = "Delete product by id")
    @DeleteMapping("{id}")
    public String deleteProductById(@PathVariable Long id) {
        productRepository.delete(getProductById(id));
        return "Deleted successfully";
    }
    @Operation(summary = "Update product by id")
    @PutMapping("{id}")
    public Product updateProductById(@PathVariable Long id,@RequestBody ProductRequest productRequest) {
        Product productById = getProductById(id);
        productById.setName(productRequest.getName());
        productById.setPrice(productRequest.getPrice());
        return productRepository.save(productById);
    }
    @Operation(summary = "Create a new product")
    @PostMapping
    public Product createProduct(@RequestBody ProductRequest productRequest) {
        return productRepository.save(productRequest.toEntity());
    }
}
