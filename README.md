# 📦 Inventory Management API

## 🚀 Overview

The **Inventory Management API** is a RESTful backend application built using Spring Boot to efficiently manage products and their stock levels. The system is designed following a layered architecture (Controller, Service, Repository) to ensure separation of concerns, scalability, and maintainability.

This application allows users to perform core operations such as creating, updating, retrieving, and listing products, along with managing inventory through stock increase and decrease functionalities. It also provides a dedicated endpoint to identify low-stock products, enabling better inventory monitoring.

A key focus of this project is enforcing **business rules and data integrity**, such as:

* Ensuring product prices are always greater than zero
* Preventing stock levels from going below zero
* Avoiding duplicate product entries based on name

The application leverages **Spring Data JPA with Hibernate** for database interactions and uses an **H2 in-memory database** for lightweight and fast development/testing. Proper exception handling is implemented using a global exception handler to return meaningful error messages and appropriate HTTP status codes.

Overall, this project demonstrates best practices in building REST APIs, including clean architecture, validation logic, structured error handling, and efficient data persistence, making it a solid foundation for real-world backend systems.


## 🛠️ Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA (Hibernate)
* H2 In-Memory Database
* Maven

##  Project Structure

com.example.inventory
│
├── controller      // REST endpoints
├── service         // Business logic
├── repository      // Database layer
├── entity          // Product model
├── exception       // Custom exceptions & handler

### 🧾 Product Module

* Add new product
* Update product details
* View product by ID
* List all products

### Inventory Module

* Increase stock quantity
* Decrease stock quantity
* View low-stock products (quantity < 5)

## Business Rules

* Product price must be greater than zero
* Stock quantity cannot be negative
* Duplicate product names are not allowed

##  Exception Handling

* Global exception handling using `@RestControllerAdvice`
* Proper HTTP status codes:

  * 400 → Bad Request
  * 404 → Not Found
  * 500 → Internal Server Error


## API Endpoints

| Method | Endpoint                        | Description            |
| ------ | ------------------------------- | ---------------------- |
| POST   | /products                       | Add product            |
| GET    | /products                       | Get all products       |
| GET    | /products/{id}                  | Get product by ID      |
| PUT    | /products/{id}                  | Update product         |
| PATCH  | /products/{id}/increase?amount= | Increase stock         |
| PATCH  | /products/{id}/decrease?amount= | Decrease stock         |
| GET    | /products/low-stock             | Get low-stock products |

##  Sample Request

###  Add Product

json
{
  "name": "Laptop",
  "category": "Electronics",
  "price": 50000,
  "quantity": 10
}

##  Sample Error Response

json
{
  "message": "Stock cannot go below zero"
}

##  H2 Database

* Console URL: http://localhost:8080/h2-console
* JDBC URL: jdbc:h2:mem:testdb
* Username: sa
* Password: (leave empty)

##  How to Run

1. Open project in IDE
2. Run `InventoryApplication.java`
3. Access APIs at:
http://localhost:8080/products

##  Testing

Use tools like Postman to test APIs:

* Add product
* Update product
* Manage stock
* Check low-stock products

##  Conclusion

The Inventory Management API successfully demonstrates the development of a structured and maintainable RESTful backend system using Spring Boot. It implements essential product and inventory operations while strictly enforcing business rules to maintain data consistency and reliability.
Through the use of a layered architecture, the application ensures clear separation of concerns, making the codebase easier to understand, extend, and maintain. Integration with Spring Data JPA and an H2 in-memory database enables efficient data persistence and quick testing, while global exception handling improves robustness by providing meaningful and standardized error responses.

This project reflects practical backend development skills, including API design, validation logic, database integration, and error handling. It serves as a strong foundation for building scalable enterprise-level applications and can be further enhanced with features such as authentication, logging, and deployment to production environments.

Overall, the project highlights a solid understanding of modern Java backend development practices and readiness to handle real-world application requirements.


