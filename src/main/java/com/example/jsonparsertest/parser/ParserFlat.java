package com.example.jsonparsertest.parser;

import com.example.jsonparsertest.model.orders.ParsedOrder;
import com.example.jsonparsertest.model.orders.flat.OrderResponseFlat;
import tools.jackson.databind.ObjectMapper;

public class ParserFlat implements OrderPayloadParser {

    @Override
    public ParsedOrder parse(String json) {

        ObjectMapper mapper = new ObjectMapper();
        OrderResponseFlat flat = mapper.readValue(json, OrderResponseFlat.class);

        ParsedOrder parsedOrder = new ParsedOrder();

        parsedOrder.setCustomerName(flat.getCustomerName());
        parsedOrder.setCustomerEmail(flat.getCustomerEmail());
        parsedOrder.setId(flat.getId());

        return parsedOrder;
    }
}
