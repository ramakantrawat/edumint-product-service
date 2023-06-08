package com.example.demo.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductRequest {
    @NotNull(message = "Name can't be empty")
    private String name;
    @NotNull(message = "Description can't be empty")
    private String description;
    @NotNull(message = "Price can't be empty")
    private BigDecimal price;
}
