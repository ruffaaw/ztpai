package com.example.ztpai.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity(name = "products-type")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "typename")
    private String typename;

    public ProductType() {
    }

    public ProductType(Integer id, String typename) {
        this.id = id;
        this.typename = typename;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }
}
