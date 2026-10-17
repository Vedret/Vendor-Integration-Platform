# Vendor Integration Platform

## Vision

A platform that receives data from multiple external vendors in different formats
(JSON, XML, CSV), transforms them into a common business model, validates them,
stores them, and exposes them through APIs.

The project should evolve from a simple parser exercise into an enterprise-style
integration platform using:

- Java 21
- Spring Boot
- PostgreSQL
- Docker
- Azure
- JUnit / Mockito
- Design Patterns

---

# Iteration 1 - MVP

## Goal

Receive vendor payloads and normalize them into a common model.

### Features

- REST endpoint

```http
POST /orders
```

- Vendor A payload support
- Vendor B payload support
- Common DTO

```java
ParsedOrder
```

- Parser interface

```java
OrderParser
```

- Multiple implementations

```java
FlatParser
NestedParser
```

### Patterns

- DTO
- Strategy

### Learning

- Jackson
- JSON parsing
- Interface-based design

---

# Iteration 2 - Runtime Parser Selection

## Goal

Dynamically select parser implementation.

### Features

- ParserFactory

```java
OrderParser parser =
        parserFactory.getParser(source);
```

### Patterns

- Factory
- Strategy

### Learning

- Runtime polymorphism
- Open-closed principle

---

# Iteration 3 - PostgreSQL Persistence

## Goal

Store normalized orders.

### Features

Database schema:

```sql
orders
```

Fields:

```text
id
vendor
customer_name
customer_email
created_at
```

### API

```http
GET /orders

GET /orders/{id}
```

### Patterns

- Repository

### Learning

- Spring Data JPA
- PostgreSQL
- Entity mapping

---

# Iteration 4 - Validation Layer

## Goal

Validate incoming data before processing.

### Validators

```java
CustomerValidator
IdValidator
EmailValidator
```

### Patterns

- Chain of Responsibility

### Learning

- Validation architecture
- Responsibility segregation

---

# Iteration 5 - Import History

## Goal

Track every import request.

### Tables

```text
imports
```

Track:

- vendor
- request timestamp
- status
- error message

### Benefits

- Auditing
- Troubleshooting

### Learning

- Audit trail design

---

# Iteration 6 - File Import

## Goal

Import files instead of direct payloads.

### Supported

- JSON
- CSV

### New Components

```java
FileParser
JsonFileParser
CsvFileParser
```

### Patterns

- Strategy
- Factory

### Learning

- Multipart uploads
- Data ingestion

---

# Iteration 7 - Azure Blob Storage

## Goal

Store raw payloads in Azure.

### Flow

```text
Upload
 ↓
Blob Storage
 ↓
Process
 ↓
Store results
```

### Learning

- Azure Blob Storage
- Externalized storage

---

# Iteration 8 - Event-Driven Processing

## Goal

Generate events when orders are processed.

### Event

```java
OrderImportedEvent
```

### Listeners

```java
AuditListener
NotificationListener
StatisticsListener
```

### Patterns

- Observer

### Learning

- Spring Events
- Loose coupling

---

# Iteration 9 - Async Processing

## Goal

Decouple import from processing.

### Flow

```text
Receive Request
 ↓
Queue Job
 ↓
Immediate Response
 ↓
Background Processing
```

### Learning

- @Async
- Thread pools

Future:

```text
Azure Service Bus
```

---

# Iteration 10 - Advanced Vendor Support

## Goal

Support many vendors.

### Examples

```text
VendorA
VendorB
VendorC
VendorD
```

Each can provide:

```text
JSON
CSV
XML
```

### Patterns

- Strategy
- Factory
- Adapter

### Learning

- Extensible architecture

---

# Iteration 11 - Security

## Goal

Protect APIs.

### Features

- JWT authentication
- Role-based authorization

Roles:

```text
ADMIN
USER
AUDITOR
```

### Learning

- Spring Security
- OAuth2 concepts

---

# Iteration 12 - Microservice Split

## Goal

Separate responsibilities.

### Services

```text
import-service

order-service

notification-service

audit-service
```

### Communication

```text
REST
```

Later:

```text
Kafka
Azure Service Bus
```

### Learning

- Distributed systems
- Service boundaries

---

# Stretch Goals

## Reporting

```http
GET /reports/vendors

GET /reports/imports

GET /reports/errors
```

## Dashboard

Angular or React frontend.

## Notifications

- Email
- Teams
- Slack

## Caching

- Redis

## Monitoring

- Prometheus
- Grafana

## CI/CD

- GitHub Actions
- Azure Pipelines
- Docker

---

# Patterns Covered

## Core

- Strategy
- Factory
- Repository
- DTO

## Intermediate

- Observer
- Adapter
- Builder
- Chain of Responsibility

## Advanced

- Event-Driven Architecture
- Producer / Consumer
- Microservices

---
