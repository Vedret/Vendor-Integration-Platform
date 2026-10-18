package com.example.jsonparsertest.parser;
public class ParserFactory {

    public static OrderPayloadParser getParserOrder(String parserType) {
        return switch (parserType) {
            case "FLAT_PAYLOAD" -> new ParserFlat();
            case "NESTED_PAYLOAD" -> new ParserNested();
            default -> null;
        };
    }
}
