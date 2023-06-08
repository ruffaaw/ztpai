package com.example.ztpai.service;

import com.example.ztpai.model.CartItem;
import com.example.ztpai.model.Products;
import com.example.ztpai.model.ShoppingCart;
import com.example.ztpai.repository.CartItemRepository;
import com.example.ztpai.repository.ProductsRepository;
import com.example.ztpai.repository.ShoppingCartRepository;
import exceptions.CartItemNotFoundException;
import exceptions.ShoppingCartNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductsRepository productsRepository;

    @Autowired
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, CartItemRepository cartItemRepository, ProductsRepository productsRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.cartItemRepository = cartItemRepository;
        this.productsRepository = productsRepository;
    }

    public List<ShoppingCart> getAllShoppingCarts() {
        return shoppingCartRepository.findAll();
    }

    public ShoppingCart getShoppingCartById(UUID id) {
        return shoppingCartRepository.findById(id).orElse(null);
    }

    public ShoppingCart createShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart(UUID.randomUUID(), new ArrayList<>());
        return shoppingCartRepository.save(shoppingCart);
    }

    public ShoppingCart updateShoppingCart(UUID id, ShoppingCart updatedShoppingCart) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(id).orElse(null);
        if (shoppingCart != null) {
            shoppingCart.setCartItems(updatedShoppingCart.getCartItems());
            return shoppingCartRepository.save(shoppingCart);
        } else {
            return null;
        }
    }

    public boolean deleteShoppingCart(UUID id) {
        if (shoppingCartRepository.existsById(id)) {
            shoppingCartRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public CartItem addItemToCart(UUID cartId, CartItem cartItem) throws ShoppingCartNotFoundException, CartItemNotFoundException {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(cartId)
                .orElseThrow(() -> new ShoppingCartNotFoundException("Shopping cart not found"));

        if (cartItem.getProducts() == null) {
            throw new CartItemNotFoundException("Product not found");
        }

        Products product = productsRepository.findById(cartItem.getProducts().getId())
                .orElseThrow(() -> new CartItemNotFoundException("Product not found"));

        // Sprawdź, czy już istnieje CartItem dla danego produktu w koszyku
        CartItem existingCartItem = shoppingCart.getCartItems().stream()
                .filter(item -> item.getProducts().getId().equals(product.getId()))
                .findFirst()
                .orElse(null);

        if (existingCartItem != null) {
            // Jeżeli CartItem dla danego produktu już istnieje, dodaj do niego ilość
            int newQuantity = existingCartItem.getQuantity() + cartItem.getQuantity();
            existingCartItem.setQuantity(newQuantity);
            cartItemRepository.save(existingCartItem);
            return existingCartItem;
        } else {
            // Jeżeli CartItem dla danego produktu nie istnieje, stwórz nowy
            CartItem newCartItem = new CartItem();
            newCartItem.setProducts(product);
            newCartItem.setQuantity(cartItem.getQuantity());
            newCartItem.setShoppingCart(shoppingCart);
            shoppingCart.getCartItems().add(newCartItem);
            shoppingCartRepository.save(shoppingCart);
            return newCartItem;
        }
    }

    public void removeCartItem(UUID cartId, UUID itemId) throws ShoppingCartNotFoundException, CartItemNotFoundException {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(cartId)
                .orElseThrow(() -> new ShoppingCartNotFoundException("Shopping cart not found"));

        CartItem cartItem = shoppingCart.getCartItems()
                .stream()
                .filter(item -> item.getCartItemsId().equals(itemId))
                .findFirst()
                .orElseThrow(() -> new CartItemNotFoundException("Cart item not found"));

        shoppingCart.getCartItems().remove(cartItem);
        cartItemRepository.delete(cartItem);
    }
}
