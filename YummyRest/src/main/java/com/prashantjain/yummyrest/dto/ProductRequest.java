package com.prashantjain.yummyrest.dto;

import  com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public record ProductRequest(
        @NotNull(message = "Product should be present")
        @NotEmpty(message = "Product should be present")
        @NotBlank(message = "Product should be present")
        @JsonProperty("name")
        String name,


        @NotNull(message="Product price is required")
        @JsonProperty("price")
        float price


) {
}


