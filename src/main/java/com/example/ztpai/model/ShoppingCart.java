package com.example.ztpai.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "shopping-cart")
public class ShoppingCart {
    @Id
    private UUID id;
    @OneToMany(cascade = CascadeType.ALL)
    private ArrayList<CartItem> products;

    public ShoppingCart() {
    }

    public ShoppingCart(UUID id, ArrayList<CartItem> products) {
        this.id = id;
        this.products = new ArrayList<>(products);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<CartItem> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<CartItem> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return Objects.equals(id, that.id) && Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, products);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", products=" + products +
                '}';
    }
}
