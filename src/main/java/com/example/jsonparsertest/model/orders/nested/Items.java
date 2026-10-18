package com.example.jsonparsertest.model.orders.nested;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Items {

    private String name;
    private BigDecimal price;
    private int quantity;

}
