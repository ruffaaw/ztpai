package com.example.ztpai.repository;

import com.example.ztpai.model.ShoppingCart;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ShoppingCartRepository {
    public ShoppingCartRepository() {

    }

    private final List<ShoppingCart> shoppingCarts = new ArrayList<>();

    public List<ShoppingCart> findAll() {
        return shoppingCarts;
    }

    public Optional<ShoppingCart> findById(UUID id) {
        return shoppingCarts.stream()
                .filter(cart -> cart.getId().equals(id))
                .findFirst();
    }

    public void save(ShoppingCart shoppingCart) {
        shoppingCarts.add(shoppingCart);
    }

    public void deleteById(UUID id) {
        shoppingCarts.removeIf(cart -> cart.getId().equals(id));
    }

}
