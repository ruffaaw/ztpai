package com.example.ztpai.model;

import jakarta.validation.constraints.NotBlank;

public record Person(
        Integer id,
        @NotBlank
        String name,
        @NotBlank
        String surname,
        @NotBlank
        String password,
        String phone
) {
}
