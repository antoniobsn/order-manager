# order-manager
**Spring Boot-based Order Management API** built using **Clean Architecture (Hexagonal Architecture)** principles.

---

## 📌 Overview

This project allows you to:
- Retrieve customer orders
- Calculate order totals
- Group orders by status
- Identify the most expensive order in a list

---

## 🧱 Architecture

The project follows **Hexagonal Architecture (Ports & Adapters)**:

---

## Requirements
- Java 17+
- Gradle 8+
- Docker
---

### Run Container (Docker)

***Build image:***

````bash
docker build -t order-manager .
````

***Run container:***
```bash
docker run -p 8080:8080 order-manager
```
---

### Resources

🔎 Get orders by customer 

**GET** `/api/customer/{customerId}/orders`



### 📥 Response Example

```json
[
  {
    "id": 1,
    "customerId": 1,
    "orderItems": [
      {
        "quantity": 1,
        "unitPrice": 70
      }
    ],
    "orderStatus": "PENDING"
  }
]
```
---