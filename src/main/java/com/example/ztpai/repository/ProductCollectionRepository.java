package com.example.ztpai.repository;

import com.example.ztpai.model.Product;
import com.example.ztpai.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductCollectionRepository {
    private final List<Product> productList = new ArrayList<>();

    public ProductCollectionRepository() {
    }

    public List<Product> findAll() {
        return productList;
    }

    public Optional<Product> findById(Integer id) {
        return productList.stream().filter(c -> c.id().equals(id)).findFirst();
    }



    public void save(Product product) {
        productList.removeIf(c -> c.id().equals(product.id()));
        productList.add(product);
    }

    @PostConstruct
    private void init() {
        Product product = new Product(1,
                Type.DESKTOP,
                "Komputer gamingowy",
                5000,
                "./img/komp.png",
                "");
        productList.add(product);
    }

    public boolean existsById(Integer id) {
        return productList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    public void delete(Integer id) {
        productList.removeIf(c -> c.id().equals(id));
    }
}
