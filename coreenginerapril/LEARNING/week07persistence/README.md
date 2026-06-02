# Week 7 — Database Persistence

Overview
- Connect Spring Boot to MySQL and use Spring Data JPA for persistence.

Entity + repository example:

```java
@Entity
public class Client {
    @Id @GeneratedValue Long id;
    String name;
    String email;
    BigDecimal balance;
}

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByEmail(String email);
}
```

Quick tips
- Use `application.properties` for DB credentials (do not commit secrets).
- Use `spring.jpa.hibernate.ddl-auto=update` while developing, but prefer migrations for production.

Exercises
- Save/read clients using `ClientRepository` in a service.
- Add a Flyway migration (optional).
