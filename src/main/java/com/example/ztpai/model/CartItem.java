package com.example.ztpai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity(name = "cart-item")
public class CartItem {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID cartItemsId;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products products;
    @Column(name = "quantity")
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "shopping_cart_id")
    @JsonIgnore
    private ShoppingCart shoppingCart;

    public CartItem() {
    }

    public CartItem(UUID cartItemsId, Products products, Integer quantity, ShoppingCart shoppingCart) {
        this.cartItemsId = cartItemsId;
        this.products = products;
        this.quantity = quantity;
        this.shoppingCart = shoppingCart;
    }

    public UUID getCartItemsId() {
        return cartItemsId;
    }

    public void setCartItemsId(UUID cartItemsId) {
        this.cartItemsId = cartItemsId;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return Objects.equals(cartItemsId, cartItem.cartItemsId) && Objects.equals(products, cartItem.products) && Objects.equals(quantity, cartItem.quantity) && Objects.equals(shoppingCart, cartItem.shoppingCart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartItemsId, products, quantity, shoppingCart);
    }
}
