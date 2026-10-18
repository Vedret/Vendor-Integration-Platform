package com.example.jsonparsertest;

import com.example.jsonparsertest.model.orders.ParsedOrder;
import com.example.jsonparsertest.parser.ParserFactory;
import com.example.jsonparsertest.parser.OrderPayloadParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.example.jsonparsertest.util.Payloads.FLAT_PAYLOAD;
import static com.example.jsonparsertest.util.Payloads.NESTED_PAYLOAD;

@SpringBootApplication
public class JsonParserTestApplication {

    private static final Logger logger = LoggerFactory.getLogger(JsonParserTestApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(JsonParserTestApplication.class, args);

        OrderPayloadParser parser =
                ParserFactory.getParserOrder("FLAT_PAYLOAD");

        OrderPayloadParser parserNested =
                ParserFactory.getParserOrder("NESTED_PAYLOAD");

        logParsedOrder("Flat", parser.parse(FLAT_PAYLOAD));
        logParsedOrder("Nested", parserNested.parse(NESTED_PAYLOAD));
    }

    private static void logParsedOrder(String format, ParsedOrder order) {
        logger.info("{} parsed order: id={}, customerName={}, customerEmail={}",
                format, order.getId(), order.getCustomerName(), order.getCustomerEmail());
    }

}
