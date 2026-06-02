# Week 5 — IoC & Dependency Injection

Overview
- Learn how Spring Boot manages beans (IoC) and how to wire dependencies (DI).

Why it matters
- Proper DI makes code testable, loosely coupled, and easier to maintain.

Tiny example (constructor injection):

```java
@Service
public class GreetingService {
    public String greet(String name) { return "Hello, " + name; }
}

@RestController
public class GreetingController {
    private final GreetingService svc;
    public GreetingController(GreetingService svc) { this.svc = svc; }
    @GetMapping("/greet")
    public String greet(@RequestParam(defaultValue = "World") String name) {
        return svc.greet(name);
    }
}
```

Exercises
- Convert a field-injected bean to constructor injection.
- Write a unit test for `GreetingService`.
