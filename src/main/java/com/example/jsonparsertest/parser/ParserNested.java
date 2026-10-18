package com.example.jsonparsertest.parser;

import com.example.jsonparsertest.model.orders.ParsedOrder;
import com.example.jsonparsertest.model.orders.nested.OrderResponse;
import tools.jackson.databind.ObjectMapper;

public class ParserNested implements OrderPayloadParser {
    @Override
    public ParsedOrder parse(String json) {

        ObjectMapper mapper = new ObjectMapper();
        OrderResponse response = mapper.readValue(json, OrderResponse.class);

        ParsedOrder parsedOrder = new ParsedOrder();

        parsedOrder.setCustomerName(response.getOrder().getCustomer().getName());
        parsedOrder.setCustomerEmail(response.getOrder().getCustomer().getEmail());
        parsedOrder.setId(response.getOrder().getDetails().getId());

        return parsedOrder;
    }
}
