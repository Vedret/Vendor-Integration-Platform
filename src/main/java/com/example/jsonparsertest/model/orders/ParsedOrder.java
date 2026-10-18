package com.example.jsonparsertest.model.orders;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ParsedOrder {

    private String id;
    private String customerName;
    private String customerEmail;
}
