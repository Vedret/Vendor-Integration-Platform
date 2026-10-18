package com.example.jsonparsertest.parser;

import com.example.jsonparsertest.model.orders.ParsedOrder;

public interface OrderPayloadParser {

    ParsedOrder parse(String json);

}
