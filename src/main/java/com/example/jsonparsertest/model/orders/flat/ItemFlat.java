package com.example.jsonparsertest.model.orders.flat;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ItemFlat {
    private String name;
    private BigDecimal price;
}
