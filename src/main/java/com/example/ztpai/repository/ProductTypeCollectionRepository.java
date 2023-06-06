package com.example.ztpai.repository;

import com.example.ztpai.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeCollectionRepository extends JpaRepository<ProductType, Integer> {
}
