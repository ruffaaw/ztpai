package com.example.ztpai.repository;

import com.example.ztpai.model.Products;
import com.example.ztpai.model.ProductType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ProductsCollectionRepository {
    private final List<Products> products = new ArrayList<>();

    public ProductsCollectionRepository() {
        init();
    }

    public List<Products> findAll() {
        return products;
    }

    public Optional<Products> findById(UUID id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    public void save(Products product) {
        products.add(product);
    }

    public void deleteById(UUID id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    public void init(){
        ProductType productType = new ProductType();
        productType.setId(1);
        productType.setTypename("Laptop");

        Products product = new Products();
        product.setId(UUID.randomUUID());
        System.out.println(product.getId());
        product.setProductType(productType);
        product.setName("Laptop");
        product.setPrice(1500);
        product.setImage("laptop.jpg");

        products.add(product);
    }
}
