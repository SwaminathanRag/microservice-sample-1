# microservice-sample-1
This repository contains sample code for below microservice concepts:

Microservice 1: api-gateway
Spring Cloud API Gateway
Netflix Eureka Naming Client and client side load balancer
Micrometer as observability api
OpenTelemetry as bridge to zipkin
generating docker image

Microservice 2: currency-conversion-service
Consumer microservice using Open Feign Client
Netflix Eureka Naming Client and client side load balancer
Micrometer as observability api
OpenTelemetry as bridge to zipkin
generating docker image

Microservice 3: currency-exchange-service
Spring boot Data JPA
H2 Database
Netflix Eureka Naming Client and client side load balancer
Micrometer as observability api
OpenTelemetry as bridge to zipkin
generating docker image
Resilience4j fault tolerance (circuit breaker)

Microservice 4: naming-server
Netflix Eureka Naming Server

Microservice 5: limits-service
Spring Boot Config client

Microservice 6: spring-cloud-config-server
Spring Boot Config Server


Not included:
Zipkin Distributed tracing server container running in docker engine

docker-compose.yaml - contains configuration for deploying microservice 1-4 in Docker
currency-kubedeployment.yaml - contains configuration for deploying microservice 1-4 in Kubernetes
