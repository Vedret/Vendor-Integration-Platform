package com.example.jsonparsertest.util;

public class Payloads {
    public static final String FLAT_PAYLOAD = """
            {
              "id": "ORDER-1001",
              "customerName": "John Doe",
              "customerEmail": "john.doe@email.com",
              "items": [
                {
                  "name": "Laptop",
                  "price": 1200
                },
                {
                  "name": "Mouse",
                  "price": 25
                }
              ]
            }
            """;

    public static final String NESTED_PAYLOAD = """
            {
              "order": {
                "details": {
                  "id": "ORDER-2002",
                  "createdAt": "2026-10-16"
                },
                "customer": {
                  "name": "Jane Smith",
                  "email": "jane.smith@email.com"
                },
                "items": [
                  {
                    "name": "Keyboard",
                    "price": 75,
                    "quantity": 2
                  },
                  {
                    "name": "Monitor",
                    "price": 300,
                    "quantity": 1
                  }
                ]
              }
            }
            """;
}
