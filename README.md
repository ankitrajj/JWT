**JWT(JSON WEB TOKEN) & Role-Based Authentication - Spring Boot Application**

This project demonstrates **JWT authentication** and **Role-Based Authorization** using **Spring Boot 3**, **Spring Security**, and **JPA**.  
It provides a secure backend API where users can register, log in, and access endpoints based on assigned roles (e.g., `USER`, `ADMIN`).

---

## Features

- User registration and login using JWT  
- Role-based access control (`ADMIN`, `USER`, etc.)  
- Token validation and expiration handling  
- Spring Security with `OncePerRequestFilter`  
- Exception handling and custom responses  
- Swagger API documentation  
- MySQL database integration  
- Modular & production-ready structure

---

## Tech Stack

| Category | Technology |
|-----------|-------------|
| **Backend Framework** | Spring Boot 3.x |
| **Security** | Spring Security + JWT |
| **Database** | MySQL  |
| **ORM** | Spring Data JPA |
| **Documentation** | Springdoc OpenAPI |
| **Build Tool** | Maven |
| **Java Version** | 17 or higher |

---

## 📁 Project Structure
```JWT-Authentication/
├── src/
│ ├── main/
│ │ ├── java/in/ankit/
| | | ├── bindings (LoginUser, RegisterUser)
│ │ │ ├── controllers/ # REST Controllers (AdminController, UserController)
│ │ │ ├── config/ # Configuration classes (SecurityConfig)
│ │ │ ├── security/ # JWT Services ( JwtAuthFilter, JwtService, CustomUserDetails)
│ │ │ ├── service/ # Business logic layer (UserService, UserServiceImpl)
│ │ │ ├── models/ # Entity classes (UserEntity)
│ │ │ ├── repos/ # Data access layer (UserRepository)
│ │ │ └── Application.java
│ │ └── resources/
│ │    ├── application.properties
├── pom.xml # Maven configuration
└── README.md # Project documentation
```

---

## ⚙️ Setup & Installation

### 1. Clone the Repository
```bash
git clone https://github.com/ankitrajj/JWT.git
cd JWT
```
### 2. Build & Run
```bash
mvn clean install
mvn spring-boot:run
```
The app will start on:
👉 http://localhost:8080

---
## 🔐 API Endpoints
| Method | Endpoint               | Description                         | Access       |
| ------ | ---------------------- | ----------------------------------- | ------------ |
| `POST` | `/api/auth/register`   | Register new user                   | Public       |
| `POST` | `/api/auth/login`      | Authenticate user and get JWT token | Public       |
| `GET`  | `/api/user/profile`    | Get user profile                    | USER / ADMIN |
| `GET`  | `/api/admin/dashboard` | Admin-only endpoint                 | ADMIN        |

---
## Authentication Flow
1. Register a new user with /api/auth/register.
2. Login using /api/auth/login → receive a JWT token.
3. Include token in header for all requests:
      Authorization: Bearer <your_token>
4. Spring Security verifies and authorizes based on user roles.
---
## Swagger API Docs
After running the application, open:
👉 http://localhost:8080/swagger-ui.html
