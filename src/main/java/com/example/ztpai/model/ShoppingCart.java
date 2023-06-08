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
    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL)
    private List<CartItem> cartItems;

    public ShoppingCart() {
    }

    public ShoppingCart(UUID id, List<CartItem> cartItems) {
        this.id = id;
        this.cartItems = new ArrayList<>(cartItems);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return Objects.equals(id, that.id) && Objects.equals(cartItems, that.cartItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cartItems);
    }
}


