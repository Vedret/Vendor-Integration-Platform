package com.example.jsonparsertest.model.orders.flat;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderResponseFlat {

    private String id;
    private String customerName;
    private String customerEmail;
    private List<ItemFlat> items;

}
