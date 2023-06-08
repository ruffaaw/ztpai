package com.example.ztpai.controllers;

import com.example.ztpai.model.CartItem;
import com.example.ztpai.model.ShoppingCart;
import com.example.ztpai.service.ShoppingCartService;
import com.example.ztpai.exceptions.CartItemNotFoundException;
import com.example.ztpai.exceptions.ShoppingCartNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/shopping-cart")
@CrossOrigin
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("")
    public ResponseEntity<List<ShoppingCart>> getAllShoppingCarts() {
        List<ShoppingCart> shoppingCarts = shoppingCartService.getAllShoppingCarts();
        return ResponseEntity.ok(shoppingCarts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingCart> getShoppingCartById(@PathVariable UUID id) {
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCartById(id);
        if (shoppingCart != null) {
            return ResponseEntity.ok(shoppingCart);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<ShoppingCart> createShoppingCart() {
        ShoppingCart shoppingCart = shoppingCartService.createShoppingCart();
        return ResponseEntity.created(URI.create("/api/shopping-cart/" + shoppingCart.getId())).body(shoppingCart);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShoppingCart> updateShoppingCart(@PathVariable UUID id, @RequestBody ShoppingCart shoppingCart) {
        ShoppingCart updatedShoppingCart = shoppingCartService.updateShoppingCart(id, shoppingCart);
        if (updatedShoppingCart != null) {
            return ResponseEntity.ok(updatedShoppingCart);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShoppingCart(@PathVariable UUID id) {
        boolean deleted = shoppingCartService.deleteShoppingCart(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{cartId}/add-item")
    public ResponseEntity<CartItem> addItemToCart(@PathVariable UUID cartId, @Valid @RequestBody CartItem cartItem) {
        try {
            CartItem addedItem = shoppingCartService.addItemToCart(cartId, cartItem);
            return ResponseEntity.ok(addedItem);
        } catch (CartItemNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart item not found", e);
        } catch (ShoppingCartNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Shopping cart not found", e);
        }
    }

    @DeleteMapping("/{cartId}/delete-item/{itemId}")
    public ResponseEntity<String> removeCartItem(@PathVariable UUID cartId, @PathVariable UUID itemId) {
        try {
            shoppingCartService.removeCartItem(cartId, itemId);
            return ResponseEntity.ok("Cart item removed successfully.");
        } catch (ShoppingCartNotFoundException | CartItemNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
