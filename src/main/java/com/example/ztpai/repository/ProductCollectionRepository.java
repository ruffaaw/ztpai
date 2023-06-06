package com.example.ztpai.repository;

import com.example.ztpai.model.Product;
import com.example.ztpai.model.ProductType;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductCollectionRepository {
    private final List<Product> products = new ArrayList<>();

    public ProductCollectionRepository() {
    }

    public List<Product> findAll() {
        return products;
    }

    public Optional<Product> findById(Integer id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    public void save(Product product) {
        products.add(product);
    }

    public void deleteById(Integer id) {
        products.removeIf(product -> product.getId().equals(id));
    }

}
