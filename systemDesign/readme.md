# 🗺️ SDE-1 System Design Roadmap: Topics & Prerequisites

This document outlines the core prerequisites, Low-Level Design (LLD), and High-Level Design (HLD) building blocks required for SDE-1 interviews.

---

## 🛑 Phase 0: The Prerequisites (Must Learn First)
Before diving into architectures, you must understand these foundational computer science concepts.

### 1. Networking Fundamentals
* **The Lifecycle of a Web Request:** What happens under the hood when a user types a URL into a browser? 
* **Key Concepts:**
  * DNS Lookup (Domain Name System)
  * TCP/IP Handshake
  * HTTP/HTTPS Protocols (Headers, Status Codes, Methods)
  * IP Routing & Ports

### 2. Database Core Concepts
* **How Indexes Work:** Understanding how a database finds data using B-Trees / B+ Trees instead of scanning every row ($O(\log N)$ vs $O(N)$).
* **ACID Properties:** Atomicity, Consistency, Isolation, Durability (Crucial for transactional systems like payments).

### 3. Core System Metrics
* **Latency:** How long it takes for a single request to return a response (measured in milliseconds).
* **Throughput:** How many requests a system can handle simultaneously (measured in QPS - Queries Per Second).
* **Availability:** System uptime (e.g., "Three Nines" = 99.9% uptime).

---

## 🏗️ Phase 1: High-Level Design (HLD) Building Blocks
As an SDE-1, your focus is not on designing massive systems from scratch, but knowing when and why to use these core components.

### 1. Scaling & Load Balancing
* **Vertical Scaling vs. Horizontal Scaling:** Adding more power to one machine vs. adding more machines.
* **Load Balancers (e.g., Nginx, AWS ALB):** 
  * How they distribute traffic across a fleet of backend servers.
  * Routing Algorithms: Round Robin, Least Connections, IP Hash.

### 2. Caching Strategies
* **Why Cache?** Storing frequently accessed data in RAM (Memory) to protect the slower Database (Disk).
* **Cache Eviction Policies:** What happens when the cache gets full? (e.g., **LRU - Least Recently Used**).
* **Caching Patterns:** Cache-Aside, Write-Through, Read-Through.
* **Tools:** Redis, Memcached.

### 3. Database Selection (SQL vs. NoSQL)
* **Relational Databases (SQL):** MySQL, PostgreSQL. Best for structured data and strict data integrity.
* **Non-Relational Databases (NoSQL):** MongoDB, DynamoDB, Cassandra. Best for unstructured data, high write throughput, and horizontal scaling.

### 4. Monoliths vs. Microservices
* **Monolithic Architecture:** One giant codebase containing all business logic.
* **Microservices:** Breaking the app into small, decoupled services that communicate via network calls (REST APIs, gRPC).

---

## 🛠️ Phase 2: Low-Level Design (LLD) / Object-Oriented Design
This maps directly to your clean-coding skills and your ability to write maintainable Java code.

### 1. The SOLID Principles
The golden rules of Object-Oriented Design:
* **S**ingle Responsibility Principle
* **O**pen/Closed Principle
* **L**iskov Substitution Principle
* **I**nterface Segregation Principle
* **D**ependency Inversion Principle (The core theory behind Spring Boot's Dependency Injection!)

### 2. Essential Design Patterns
* **Creational:** Singleton Pattern (e.g., Database connection pools), Factory Pattern.
* **Structural:** Adapter Pattern, Facade Pattern.
* **Behavioral:** Observer Pattern (e.g., Notification/Event-driven triggers), Strategy Pattern.

---

## ⏱️ The 4-Step Interview Execution Framework
When asked an architectural design question, use this exact time-blocked framework to organize your thoughts:

1. **Clarify Requirements (5 mins):** Ask questions to scope the problem. Define functional requirements (features) and non-functional requirements (Scale, Traffic estimations).
2. **Define APIs (5 mins):** Write out the REST endpoints or method signatures the system will expose (e.g., `POST /v1/urls`).
3. **High-Level Diagram (10 mins):** Map out the boxes and arrows. Walk data through Client ➔ Load Balancer ➔ Application Server ➔ Database.
4. **Identify Bottlenecks & Deep Dive (15 mins):** Find where the system fails under stress. Introduce Caches, Indexes, or Replication to solve the issues.