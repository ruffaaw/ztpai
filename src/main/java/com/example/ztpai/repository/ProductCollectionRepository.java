package com.example.ztpai.repository;

import com.example.ztpai.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ProductCollectionRepository {
    private final List<Product> products = new ArrayList<>();

    public ProductCollectionRepository() {
    }

    public List<Product> findAll() {
        return products;
    }

    public Optional<Product> findById(UUID id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    public void save(Product product) {
        products.add(product);
    }

    public void deleteById(UUID id) {
        products.removeIf(product -> product.getId().equals(id));
    }

}
