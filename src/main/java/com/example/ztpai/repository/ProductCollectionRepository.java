package com.example.ztpai.repository;

import com.example.ztpai.model.Product;
import com.example.ztpai.model.ProductType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ProductCollectionRepository {
    private final List<Product> products = new ArrayList<>();

    public ProductCollectionRepository() {
        init();
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

    public void init(){
        ProductType productType = new ProductType();
        productType.setId(1);
        productType.setTypename("Laptop");

        Product product = new Product();
        product.setId(UUID.randomUUID());
        System.out.println(product.getId());
        product.setProductType(productType);
        product.setName("Laptop");
        product.setPrice(1500);
        product.setImage("laptop.jpg");

        products.add(product);
    }
}
