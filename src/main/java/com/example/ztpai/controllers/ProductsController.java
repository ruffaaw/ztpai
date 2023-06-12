package com.example.ztpai.controllers;

import com.example.ztpai.model.Products;
import com.example.ztpai.repository.ProductsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductsController {
    private final ProductsRepository productsRepository;

    @Autowired
    public ProductsController(ProductsRepository productRepository) {
        this.productsRepository = productRepository;
    }

    @GetMapping("")
    public ResponseEntity<List<Products>> getAllProducts() {
        List<Products> productList = productsRepository.findAll();
        return ResponseEntity.ok(productList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable UUID id) {
        Optional<Products> product = productsRepository.findById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
    }

    @PostMapping("")
    public ResponseEntity<Products> createProduct(@RequestBody Products product) {
        Products createdProduct = productsRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Products> updateProduct(@PathVariable UUID id, @RequestBody Products updatedProduct) {
        Optional<Products> product = productsRepository.findById(id);
        if (product.isPresent()) {
            updatedProduct.setId(id);
            Products savedProduct = productsRepository.save(updatedProduct);
            return ResponseEntity.ok(savedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id) {
        Optional<Products> product = productsRepository.findById(id);
        if (product.isPresent()) {
            productsRepository.delete(product.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/type/{typeId}")
    public ResponseEntity<List<Products>> getProductsByTypeId(@PathVariable Integer typeId) {
        List<Products> productList = productsRepository.findByProductType_Id(typeId);
        return ResponseEntity.ok(productList);
    }
}
