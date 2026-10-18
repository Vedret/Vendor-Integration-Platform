package com.example.jsonparsertest.model.orders.nested;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Order {
    private Details details;
    private Customer customer;
    private List<Items> items;
}
