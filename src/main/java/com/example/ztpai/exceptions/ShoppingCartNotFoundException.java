package com.example.ztpai.exceptions;

public class ShoppingCartNotFoundException extends RuntimeException{
    public ShoppingCartNotFoundException(String message) {
        super(message);
    }
}
