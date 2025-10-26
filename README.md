# Microstack Spring

[English version below](#microstack-spring-english)

## Sobre o Projeto

O Microstack Spring é uma estrutura base de microsserviços construída com Spring Cloud. O projeto fornece uma arquitetura escalável e pronta para produção com os seguintes componentes.

### Componentes Principais

1. **Config Server** (Porta: 8888)
   - Servidor de configuração centralizada
   - Gerencia configurações de todos os serviços
   - Baseado no Spring Cloud Config
   - Configurações armazenadas no diretório `config-repo`

2. **Eureka Server** (Porta: 8761)
   - Servidor de descoberta de serviços
   - Registra e monitora todos os microsserviços
   - Interface web disponível em `http://localhost:8761`

3. **API Gateway** (Porta: 8080)
   - Ponto de entrada único para todos os serviços
   - Roteamento dinâmico baseado em serviços registrados
   - Baseado no Spring Cloud Gateway

4. **Demo Service** (Porta: 8081)
   - Serviço de exemplo
   - Demonstra a integração com Config Server e Eureka
   - Base para criação de novos serviços

### Como Executar

1. Certifique-se de ter instalado:
   - Docker e Docker Compose
   - Java 21
   - Maven

2. Execute o projeto:
   ```bash
   docker-compose up --build
   ```

### Como Adicionar Novos Serviços

Para adicionar um novo serviço ao stack:

1. Crie um novo módulo Maven:
   ```bash
   mvn archetype:generate -DgroupId=com.microstack -DartifactId=new-service
   ```

2. Adicione as dependências no `pom.xml`:
   ```xml
   <dependencies>
       <dependency>
           <groupId>org.springframework.cloud</groupId>
           <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
       </dependency>
       <dependency>
           <groupId>org.springframework.cloud</groupId>
           <artifactId>spring-cloud-starter-config</artifactId>
       </dependency>
   </dependencies>
   ```

3. Crie o arquivo de configuração em `config-repo/new-service.yml`:
   ```yaml
   server:
     port: 8082  # Escolha uma porta disponível

   spring:
     application:
       name: new-service
   ```

4. Adicione o serviço no `docker-compose.yml`:
   ```yaml
   new-service:
     build: ./new-service
     ports:
       - "8082:8082"
     depends_on:
       - config-server
       - eureka
   ```

5. Crie um Dockerfile para o serviço:
   ```dockerfile
   FROM eclipse-temurin:21-jdk
   COPY target/*.jar app.jar
   ENTRYPOINT ["java","-jar","/app.jar"]
   ```

### Arquitetura

```
[Cliente] -> [API Gateway (8080)] -> [Serviços (8081+)]
                    ⬆
    [Eureka (8761)] ← [Config Server (8888)]
```

---

# Microstack Spring (English)

## About the Project

Microstack Spring is a microservices foundation built with Spring Cloud. The project provides a scalable, production-ready architecture with the following components:

### Main Components

1. **Config Server** (Port: 8888)
   - Centralized configuration server
   - Manages all services configurations
   - Based on Spring Cloud Config
   - Configurations stored in `config-repo` directory

2. **Eureka Server** (Port: 8761)
   - Service discovery server
   - Registers and monitors all microservices
   - Web interface available at `http://localhost:8761`

3. **API Gateway** (Port: 8080)
   - Single entry point for all services
   - Dynamic routing based on registered services
   - Based on Spring Cloud Gateway

4. **Demo Service** (Port: 8081)
   - Example service
   - Demonstrates integration with Config Server and Eureka
   - Base for creating new services

### How to Run

1. Make sure you have installed:
   - Docker and Docker Compose
   - Java 21
   - Maven

2. Run the project:
   ```bash
   docker-compose up --build
   ```

### How to Add New Services

To add a new service to the stack:

1. Create a new Maven module:
   ```bash
   mvn archetype:generate -DgroupId=com.microstack -DartifactId=new-service
   ```

2. Add dependencies in `pom.xml`:
   ```xml
   <dependencies>
       <dependency>
           <groupId>org.springframework.cloud</groupId>
           <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
       </dependency>
       <dependency>
           <groupId>org.springframework.cloud</groupId>
           <artifactId>spring-cloud-starter-config</artifactId>
       </dependency>
   </dependencies>
   ```

3. Create configuration file in `config-repo/new-service.yml`:
   ```yaml
   server:
     port: 8082  # Choose an available port

   spring:
     application:
       name: new-service
   ```

4. Add the service to `docker-compose.yml`:
   ```yaml
   new-service:
     build: ./new-service
     ports:
       - "8082:8082"
     depends_on:
       - config-server
       - eureka
   ```

5. Create a Dockerfile for the service:
   ```dockerfile
   FROM eclipse-temurin:21-jdk
   COPY target/*.jar app.jar
   ENTRYPOINT ["java","-jar","/app.jar"]
   ```

### Architecture

```
[Client] -> [API Gateway (8080)] -> [Services (8081+)]
                   ⬆
    [Eureka (8761)] ← [Config Server (8888)]
```
