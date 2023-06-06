package com.example.ztpai.model;

import java.util.List;
import java.util.Objects;

public class ShoppingCart {
    private Integer id;
    private List<CartItem> products;

    public ShoppingCart() {
    }

    public ShoppingCart(Integer id, List<CartItem> products) {
        this.id = id;
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<CartItem> getProducts() {
        return products;
    }

    public void setProducts(List<CartItem> products) {
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
