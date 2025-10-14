# ☁️ Microstack Spring — Mini Microservices Environment with Spring Cloud

This project implements a complete **microservices environment using Java and Spring Boot**, leveraging key components from **Spring Cloud Netflix**.

---

## 🧩 Architecture Overview

```
Client → API Gateway → Eureka Server → Microservices
                    ↘ Config Server ↗
```

### Components

| Service | Role | Port |
|----------|------|------|
| **config-server** | Centralized configuration server | 8888 |
| **eureka-server** | Service registry and discovery | 8761 |
| **api-gateway** | Entry point and routing | 8080 |
| **demo-service** | Example microservice | Random (Eureka-assigned) |

---

## 🧰 Technologies

- Java 17+
- Spring Boot 3.3
- Spring Cloud 2023
- Eureka Server / Client
- Spring Cloud Config
- Spring Cloud Gateway
- Maven

---

## 🚀 How to Run

1. **Start Config Server**
   ```bash
   cd config-server
   mvn spring-boot:run
   ```

2. **Start Eureka Server**
   ```bash
   cd eureka-server
   mvn spring-boot:run
   ```

3. **Start Demo Service**
   ```bash
   cd demo-service
   mvn spring-boot:run
   ```

4. **Start API Gateway**
   ```bash
   cd api-gateway
   mvn spring-boot:run
   ```

---

## ✅ Test Routing

Run:
```bash
curl -s http://localhost:8080/demo/hello
```

Expected response:
```
Hello from Microstack config global
```

---

## 🧠 Next Steps

- Add new microservices (user-service, order-service, etc.)
- Add Docker Compose for orchestration
- Add monitoring (Actuator + Prometheus)
- Implement JWT authentication on API Gateway

---

## 📄 License

This project is licensed under the MIT License — feel free to use and modify it.
