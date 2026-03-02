# 🚀 SDE-Prep-2026: Java Backend Engineer Roadmap

> **3-Month Intensive Program**: From Java Fundamentals to Production-Ready Spring Boot Applications

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.x-blue.svg)](https://www.mysql.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

---

## 📋 Table of Contents

- [Overview](#overview)
- [Repository Structure](#repository-structure)
- [Phase 1: Foundation - March](#phase-1-foundation---march)
- [Phase 2: Core Engineer - April](#phase-2-core-engineer---april)
- [Phase 3: Expert Ready - May](#phase-3-expert-ready---may)
- [DSA Progress Tracker](#dsa-progress-tracker)
- [Tech Stack](#tech-stack)
- [Setup Instructions](#setup-instructions)
- [Learning Resources](#learning-resources)

---

## 🎯 Overview

This repository documents my journey from Java fundamentals to becoming a production-ready backend engineer. The program is structured as a 3-month intensive covering:

- **Core Java & OOP Principles**
- **Spring Boot & REST API Development**
- **Database Design & JPA/Hibernate**
- **Security & Authentication (JWT)**
- **Data Structures & Algorithms (NeetCode 150)**
- **Testing, Deployment & Best Practices**

**Goal**: Build a production-ready RESTful API with authentication, CRUD operations, and comprehensive test coverage.

---

## 📁 Repository Structure

```
SDE-Prep-2026/
├── 01-Foundation-March/           # Phase 1: Java & OOPs
│   ├── week-01-encapsulation/     # User class + JVM Memory Notes
│   ├── week-02-inheritance/       # Vehicle System + Linux CLI basics
│   ├── week-03-abstraction/       # Payment Interface (UPI/CreditCard)
│   └── week-04-modern-java/       # Lambdas, Streams, & SQL Scripts
│
├── 02-Core-Engineer-April/        # Phase 2: Spring Boot & Intermediate DSA
│   ├── week-05-ioc-di/            # IoC & DI Notes + Gradle Wrapper setup
│   ├── week-06-rest-apis/         # "Hello User" API implementation
│   ├── week-07-persistence/       # JPA Entities & MySQL Config
│   └── week-08-relationships/     # User-Post @OneToMany mapping
│
├── 03-Expert-Ready-May/           # Phase 3: Advanced Topics & Production
│   ├── week-09-security-jwt/      # JWT Authentication logic
│   ├── week-10-dto-pattern/       # Data Transfer Objects (UserDTO)
│   ├── week-11-testing/           # JUnit 5 & Mockito test cases
│   └── week-12-packaging/         # JAR files & GitHub Portfolio polish
│
├── 04-DSA-Solutions/              # NeetCode 150 Organized by Week
│   ├── month-1-arrays-pointers/   # Arrays, Hashing, 2-Pointers, Sliding Window
│   ├── month-2-stack-linkedlists/ # Stacks, Binary Search, Trees Pt. 1
│   └── month-3-advanced-dsa/      # Trees Pt. 2, Heaps, Graphs, Dynamic Programming
│
├── backend-project/               # 🌟 The Living Spring Boot Gradle Project
│   ├── gradlew                    # Gradle Wrapper script
│   ├── build.gradle               # Dependency management (MySQL, JPA, Security)
│   └── src/
│       ├── main/java/com/sumit/
│       │   ├── config/            # Security & Bean Configs
│       │   ├── controller/        # REST Endpoints
│       │   ├── dto/               # Data Transfer Objects (Phase 3)
│       │   ├── model/             # JPA Entities
│       │   ├── repository/        # Spring Data JPA interfaces
│       │   └── service/           # Business Logic (using Interfaces)
│       └── test/java/com/sumit/   # Unit & Integration Tests (Phase 3)
│
└── README.md                      # This file - Progress Tracker
```

---

## 📅 Phase 1: Foundation - March

**Focus**: Java Fundamentals, OOP Principles, and Basic DSA

### Week 1: Encapsulation & Arrays/Hashing
- [ ] **DSA Topics**: Arrays & Hashing (10 problems)
  - [ ] Contains Duplicate
  - [ ] Valid Anagram
  - [ ] Two Sum
  - [ ] Group Anagrams
  - [ ] Top K Frequent Elements
  - [ ] Product of Array Except Self
  - [ ] Valid Sudoku
  - [ ] Encode and Decode Strings
  - [ ] Longest Consecutive Sequence
  - [ ] 3Sum
- [ ] **Java Task**: Create `User` class with private fields (name, email, password)
- [ ] **Theory**: JVM Architecture (Stack, Heap, Method Area)
- [ ] **Tools**: Install JDK 21, IntelliJ IDEA, Git basics

### Week 2: Inheritance & Two Pointers
- [ ] **DSA Topics**: Two Pointers (5 problems)
  - [ ] Valid Palindrome
  - [ ] Two Sum II (Sorted Array)
  - [ ] 3Sum
  - [ ] Container with Most Water
  - [ ] Trapping Rain Water
- [ ] **Java Task**: Vehicle hierarchy (Car, Bike extending Vehicle)
- [ ] **Theory**: Method Overriding vs Overloading
- [ ] **Tools**: Linux CLI basics (cd, ls, mkdir, mv, chmod)

### Week 3: Abstraction & Sliding Window
- [ ] **DSA Topics**: Sliding Window (6 problems)
  - [ ] Best Time to Buy and Sell Stock
  - [ ] Longest Substring Without Repeating Characters
  - [ ] Longest Repeating Character Replacement
  - [ ] Permutation in String
  - [ ] Minimum Window Substring
  - [ ] Sliding Window Maximum
- [ ] **Java Task**: Payment interface with `processPayment()` (UPI, CreditCard implementations)
- [ ] **Theory**: Interface vs Abstract Class, when to use which

### Week 4: Modern Java & SQL Basics
- [ ] **DSA Topics**: Stack (7 problems)
  - [ ] Valid Parentheses
  - [ ] Min Stack
  - [ ] Evaluate Reverse Polish Notation
  - [ ] Generate Parentheses
  - [ ] Daily Temperatures
  - [ ] Car Fleet
  - [ ] Largest Rectangle in Histogram
- [ ] **Java Task**: Use Lambdas & Streams to filter/sort a List<User>
- [ ] **Theory**: Optional<T>, Method References, Stream API
- [ ] **SQL**: Basic CRUD queries (SELECT, INSERT, UPDATE, DELETE)

---

## 📅 Phase 2: Core Engineer - April

**Focus**: Spring Boot Framework, REST APIs, and Database Integration

### Week 5: IoC & Dependency Injection
- [ ] **DSA Topics**: Binary Search (7 problems)
  - [ ] Binary Search
  - [ ] Search a 2D Matrix
  - [ ] Koko Eating Bananas
  - [ ] Find Minimum in Rotated Sorted Array
  - [ ] Search in Rotated Sorted Array
  - [ ] Time Based Key-Value Store
  - [ ] Median of Two Sorted Arrays
- [ ] **Spring Boot**: Understand IoC Container & DI (Constructor, Setter, Field Injection)
- [ ] **Project Setup**: Initialize Gradle project with Spring Boot starter
- [ ] **Theory**: @Component, @Service, @Repository, @Autowired

### Week 6: Building REST APIs
- [ ] **DSA Topics**: Linked Lists Pt. 1 (6 problems)
  - [ ] Reverse Linked List
  - [ ] Merge Two Sorted Lists
  - [ ] Reorder List
  - [ ] Remove Nth Node From End
  - [ ] Copy List with Random Pointer
  - [ ] Add Two Numbers
- [ ] **Spring Boot**: Create `GET /api/users/{id}` and `POST /api/users`
- [ ] **Controller**: @RestController, @RequestMapping, @PathVariable, @RequestBody
- [ ] **Testing**: Use Postman/Insomnia to test endpoints

### Week 7: Database Persistence
- [ ] **DSA Topics**: Linked Lists Pt. 2 (5 problems)
  - [ ] Linked List Cycle
  - [ ] Find the Duplicate Number
  - [ ] LRU Cache
  - [ ] Merge K Sorted Lists
  - [ ] Reverse Nodes in k-Group
- [ ] **JPA/Hibernate**: Create `User` entity with @Entity, @Id, @GeneratedValue
- [ ] **Database**: MySQL setup, application.properties configuration
- [ ] **Repository**: Extend JpaRepository<User, Long>

### Week 8: Entity Relationships
- [ ] **DSA Topics**: Trees Pt. 1 (8 problems)
  - [ ] Invert Binary Tree
  - [ ] Maximum Depth of Binary Tree
  - [ ] Diameter of Binary Tree
  - [ ] Balanced Binary Tree
  - [ ] Same Tree
  - [ ] Subtree of Another Tree
  - [ ] Lowest Common Ancestor of BST
  - [ ] Binary Tree Level Order Traversal
- [ ] **JPA**: Implement User-Post relationship (@OneToMany, @ManyToOne)
- [ ] **Cascade Types**: Understand PERSIST, MERGE, REMOVE, ALL
- [ ] **Theory**: Fetch Types (LAZY vs EAGER)

---

## 📅 Phase 3: Expert Ready - May

**Focus**: Security, Testing, Production Readiness

### Week 9: JWT Authentication
- [ ] **DSA Topics**: Trees Pt. 2 (7 problems)
  - [ ] Binary Tree Right Side View
  - [ ] Count Good Nodes in Binary Tree
  - [ ] Validate Binary Search Tree
  - [ ] Kth Smallest Element in BST
  - [ ] Construct Tree from Preorder and Inorder
  - [ ] Binary Tree Maximum Path Sum
  - [ ] Serialize and Deserialize Binary Tree
- [ ] **Spring Security**: Configure JWT token generation & validation
- [ ] **Endpoints**: `POST /api/auth/register` and `POST /api/auth/login`
- [ ] **Security**: Password encoding with BCrypt

### Week 10: DTO Pattern & Error Handling
- [ ] **DSA Topics**: Tries & Heap/Priority Queue (7 problems)
  - [ ] Implement Trie
  - [ ] Design Add and Search Words
  - [ ] Word Search II
  - [ ] Kth Largest Element
  - [ ] Last Stone Weight
  - [ ] K Closest Points to Origin
  - [ ] Find Median from Data Stream
- [ ] **Pattern**: Create UserDTO to decouple API from Entity
- [ ] **Validation**: @Valid, @NotNull, @Email, @Size annotations
- [ ] **Error Handling**: @ControllerAdvice, custom exception classes

### Week 11: Testing & Code Quality
- [ ] **DSA Topics**: Backtracking & Graphs Pt. 1 (10 problems)
  - [ ] Subsets
  - [ ] Combination Sum
  - [ ] Permutations
  - [ ] Word Search
  - [ ] Number of Islands
  - [ ] Clone Graph
  - [ ] Max Area of Island
  - [ ] Pacific Atlantic Water Flow
  - [ ] Surrounded Regions
  - [ ] Rotting Oranges
- [ ] **JUnit 5**: Write unit tests for Service layer
- [ ] **Mockito**: Mock repository dependencies
- [ ] **Integration Tests**: @SpringBootTest, TestRestTemplate

### Week 12: Packaging & Deployment
- [ ] **DSA Topics**: Graphs Pt. 2 & Dynamic Programming (15 problems)
  - [ ] Course Schedule
  - [ ] Course Schedule II
  - [ ] Redundant Connection
  - [ ] Word Ladder
  - [ ] Climbing Stairs
  - [ ] Min Cost Climbing Stairs
  - [ ] House Robber
  - [ ] House Robber II
  - [ ] Longest Palindromic Substring
  - [ ] Palindromic Substrings
  - [ ] Decode Ways
  - [ ] Coin Change
  - [ ] Maximum Product Subarray
  - [ ] Word Break
  - [ ] Longest Increasing Subsequence
- [ ] **Build**: Create executable JAR with `./gradlew bootJar`
- [ ] **Docker**: Write Dockerfile for containerization (Optional)
- [ ] **Documentation**: Polish README with API endpoints, setup guide
- [ ] **Portfolio**: Push final project to GitHub with clean commit history

---

## 🧮 DSA Progress Tracker

### NeetCode 150 Progress

| Category | Total | Completed | Percentage |
|----------|-------|-----------|------------|
| Arrays & Hashing | 10 | 0 | 0% |
| Two Pointers | 5 | 0 | 0% |
| Sliding Window | 6 | 0 | 0% |
| Stack | 7 | 0 | 0% |
| Binary Search | 7 | 0 | 0% |
| Linked Lists | 11 | 0 | 0% |
| Trees | 15 | 0 | 0% |
| Tries | 3 | 0 | 0% |
| Heap/Priority Queue | 4 | 0 | 0% |
| Backtracking | 4 | 0 | 0% |
| Graphs | 9 | 0 | 0% |
| Dynamic Programming | 15 | 0 | 0% |
| **TOTAL** | **96** | **0** | **0%** |

> **Note**: Update percentages as you complete problems. Aim for 8-10 problems per week.

---

## 🛠️ Tech Stack

### Backend
- **Java**: 21 (LTS)
- **Spring Boot**: 3.x
- **Spring Data JPA**: Database abstraction
- **Spring Security**: JWT-based authentication
- **Gradle**: Build tool & dependency management

### Database
- **MySQL**: 8.x (Development)
- **H2**: In-memory (Testing)

### Testing
- **JUnit 5**: Unit testing framework
- **Mockito**: Mocking framework
- **Spring Boot Test**: Integration testing

### Tools
- **IntelliJ IDEA**: Primary IDE
- **Postman/Insomnia**: API testing
- **Git & GitHub**: Version control
- **Docker**: Containerization (Optional)

---

## ⚙️ Setup Instructions

### Prerequisites
```bash
# Verify Java installation
java -version  # Should show Java 21

# Verify Gradle (wrapper will handle this)
./gradlew --version
```

### Running the Backend Project
```bash
# Navigate to backend project
cd backend-project

# Build and run (Windows)
./gradlew.bat bootRun

# Build and run (Linux/Mac)
./gradlew bootRun

# Create executable JAR
./gradlew bootJar
```

### Database Setup
```sql
-- Create database
CREATE DATABASE sde_prep_db;

-- Create user (optional)
CREATE USER 'springuser'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON sde_prep_db.* TO 'springuser'@'localhost';
```

### Project Configuration
Update `backend-project/src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sde_prep_db
spring.datasource.username=springuser
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
```

---

## 📚 Learning Resources

### Official Documentation
- [Spring Boot Docs](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [Spring Data JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
- [Java SE 21 API](https://docs.oracle.com/en/java/javase/21/docs/api/)

### Recommended Courses
- **Java**: [Java Programming Masterclass (Udemy)](https://www.udemy.com/course/java-the-complete-java-developer-course/)
- **Spring Boot**: [Spring Framework 6 & Spring Boot 3](https://www.udemy.com/course/spring-hibernate-tutorial/)
- **DSA**: [NeetCode.io](https://neetcode.io/roadmap) | [LeetCode](https://leetcode.com/)

### Books
- *Effective Java* by Joshua Bloch
- *Spring in Action* by Craig Walls
- *Clean Code* by Robert C. Martin

---

## 🎓 Progress Notes

### What I've Learned
- Week 1: *(Add your learnings here)*
- Week 2: *(Add your learnings here)*

### Challenges Faced
- *(Document blockers and how you solved them)*

### Next Steps
- *(What's coming next week)*

---

## 📞 Connect

- **GitHub**: [Your GitHub Profile]
- **LinkedIn**: [Your LinkedIn]
- **Portfolio**: [Your Website]

---

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

**Last Updated**: March 2, 2026  
**Status**: Phase 1 - Week 1 In Progress 🚀
