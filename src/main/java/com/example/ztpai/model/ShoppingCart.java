package com.example.ztpai.model;

import jakarta.persistence.*;

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
    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return Objects.equals(id, that.id) && Objects.equals(cartItems, that.cartItems) && Objects.equals(person, that.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cartItems, person);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", cartItems=" + cartItems +
                ", person=" + person +
                '}';
    }
}


