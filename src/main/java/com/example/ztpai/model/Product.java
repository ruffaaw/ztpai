package com.example.ztpai.model;

public record Product(
        Integer id,
        Type type,
        String name,
        Integer price,
        String image,
        String url
) {
}
