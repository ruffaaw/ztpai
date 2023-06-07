package com.example.ztpai.controllers;

import com.example.ztpai.model.ShoppingCart;
import com.example.ztpai.repository.ShoppingCartCollectionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/shopping-cart")
@CrossOrigin
public class ShoppingCartController {
    private final ShoppingCartCollectionRepository shoppingCartRepository;

    @Autowired
    public ShoppingCartController(ShoppingCartCollectionRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @GetMapping("")
    public List<ShoppingCart> getAllShoppingCarts() {
        return shoppingCartRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingCart> getShoppingCartById(@PathVariable UUID id) {
        Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(id);
        if(shoppingCart.isPresent()){

        return shoppingCartRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Shopping Cart not found");
        }
    }

    @PostMapping("")
    public ResponseEntity<Void> createShoppingCart(@Valid @RequestBody ShoppingCart shoppingCart) {
        shoppingCartRepository.save(shoppingCart);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateShoppingCart(@PathVariable UUID id, @Valid @RequestBody ShoppingCart shoppingCart) {
        Optional<ShoppingCart> existingShoppingCart = shoppingCartRepository.findById(id);
        if (existingShoppingCart.isPresent()) {
            shoppingCartRepository.deleteById(id);
            shoppingCart.setId(id);
            shoppingCartRepository.save(shoppingCart);
            return ResponseEntity.noContent().build();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShoppingCart(@PathVariable UUID id) {
        shoppingCartRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
