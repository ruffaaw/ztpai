package com.example.ztpai.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record Product(
        Integer id,
        Type type,
        @NotBlank
        String name,
        Integer price,
        String image,
        String url
) {
}
