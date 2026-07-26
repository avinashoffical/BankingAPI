# 🏦 Banking API

A production-inspired **Banking REST API** built with **Java, Spring Boot, Spring Security, JWT Authentication, Spring Data JPA, Hibernate, and MySQL**. This project simulates the core functionalities of a modern banking system, including customer management, account management, secure fund transfers, loan processing, beneficiary management, and role-based access control.

The project is designed following **RESTful API principles**, **layered architecture**, and **industry-standard best practices** to demonstrate scalable backend development.

---

## 🚀 Features

### 🔐 Authentication & Authorization

* User Registration
* Secure Login with JWT Authentication
* Role-Based Authorization (ADMIN & CUSTOMER)
* Password Encryption using BCrypt
* Change Password
* Get Logged-in User Profile
* Secure API Access using Spring Security

---

### 👤 Customer Management

* View Customer Profile
* Update Customer Profile
* Get Customer Details
* View All Customers (Admin)
* Block / Unblock Customers
* Soft Delete Customer

---

### 🏦 Bank Account Management

* Create Savings or Current Account
* View Account Details
* View Customer Accounts
* Check Account Balance
* Close Account
* Freeze / Activate Account
* View All Accounts (Admin)

---

### 💸 Transaction Management

* Deposit Money
* Withdraw Money
* Transfer Funds
* View Transaction History
* Search Transaction by Reference Number
* Generate Account Statements
* Secure Transaction Processing

---

### 👥 Beneficiary Management

* Add Beneficiary
* Update Beneficiary
* Delete Beneficiary
* View Saved Beneficiaries
* Secure Beneficiary Validation

---

### 💰 Loan Management

* Apply for Loan
* Loan Approval / Rejection (Admin)
* Loan Repayment
* EMI Schedule Generation
* Loan Status Tracking
* View Customer Loans

---

### 📊 Admin Dashboard

* Customer Statistics
* Account Statistics
* Transaction Statistics
* Loan Statistics
* Dashboard Analytics

---

### 🛡️ Security

* Spring Security
* JWT Authentication
* Role-Based Access Control
* BCrypt Password Encoding
* Authentication & Authorization Filters
* Protected REST Endpoints
* Exception Handling
* Request Validation

---

## 🏗️ Tech Stack

| Technology              | Version  |
| ----------------------- | -------- |
| Java                    | 21       |
| Spring Boot             | 4.x      |
| Spring Security         | Latest   |
| Spring Data JPA         | Latest   |
| Hibernate               | Latest   |
| MySQL                   | 8+       |
| Maven                   | Latest   |
| JWT                     | Latest   |
| Lombok                  | Latest   |
| ModelMapper / MapStruct | Optional |
| Jakarta Validation      | Latest   |

---

## 📂 Project Structure

```text
src
├── config
├── controller
├── dto
│   ├── request
│   └── response
├── entity
|   └── enums
├── exception
├── repository
├── security
│   ├── jwt
│   └── service
├── service
│   ├── impl
│   └── interfaces
├── util
└── BankingApiApplication
```

---

## 📌 Modules

* Authentication Module
* Customer Module
* Account Module
* Transaction Module
* Beneficiary Module
* Loan Module
* Admin Module

---

## 🔄 API Modules

### Authentication

```
POST   /api/auth/register
POST   /api/auth/login
GET    /api/auth/me
PUT    /api/auth/change-password
```

### Customer

```
GET    /api/customers/profile
PUT    /api/customers/profile
GET    /api/customers/{id}
GET    /api/customers
```

### Account

```
POST   /api/accounts
GET    /api/accounts/my
GET    /api/accounts/{id}
GET    /api/accounts/balance/{accountNumber}
PUT    /api/accounts/{id}/close
```

### Transaction

```
POST   /api/transactions/deposit
POST   /api/transactions/withdraw
POST   /api/transactions/transfer
GET    /api/transactions/history
GET    /api/transactions/{id}
GET    /api/transactions/reference/{reference}
```

### Beneficiary

```
POST   /api/beneficiaries
GET    /api/beneficiaries
PUT    /api/beneficiaries/{id}
DELETE /api/beneficiaries/{id}
```

### Loan

```
POST   /api/loans
GET    /api/loans/my
POST   /api/loans/{id}/repay
GET    /api/loans/{id}/schedule
PUT    /api/loans/{id}/approve
PUT    /api/loans/{id}/reject
```

### Admin

```
GET    /api/admin/dashboard
GET    /api/admin/statistics
GET    /api/admin/customers
GET    /api/admin/accounts
GET    /api/admin/transactions
GET    /api/admin/loans
```

---

## 🗄️ Database Design

Main Entities

* User
* Role
* Customer
* Account
* Transaction
* Beneficiary
* Loan

Relationships

```
User
 │
 └────── Customer
              │
      ┌───────┼────────┐
      │       │        │
  Account  Beneficiary Loan
      │
      │
 Transaction
```

---

## 🔒 Authentication Flow

```
Client

↓

Login

↓

AuthenticationManager

↓

Spring Security

↓

JWT Generation

↓

JWT Returned

↓

Client stores JWT

↓

JWT sent with every request

↓

JWT Filter

↓

Authorized API Access
```

---

## 💡 Key Concepts Implemented

* RESTful API Design
* Layered Architecture
* DTO Pattern
* Repository Pattern
* Dependency Injection
* Exception Handling
* Validation
* JWT Authentication
* Role-Based Authorization
* Pagination & Sorting
* Global Exception Handling
* Secure Password Storage
* Transaction Management
* Clean Code Principles

---

---

## ▶️ Getting Started

### Clone the Repository

```bash
git clone https://github.com/your-username/banking-api.git
```

### Navigate to the Project

```bash
cd banking-api
```

### Configure the Database

Update your `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bankingapi
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### Run the Application

```bash
mvn spring-boot:run
```

The application will start on:

```
http://localhost:8080
```

---

## 📖 API Documentation

Once integrated with Swagger/OpenAPI, the API documentation will be available at:

```
http://localhost:8080/swagger-ui/index.html
```

---

## 🤝 Contributing

Contributions, suggestions, and improvements are welcome. Feel free to fork the repository, open issues, or submit pull requests.

---

## 📄 License

This project is licensed under the MIT License.

---

## 👨‍💻 Author

**Avinash Agrahari**

If you found this project helpful, consider giving it a ⭐ on GitHub!
