# Week 8 — Entity Relationships

Overview
- Model associations with JPA: `@OneToMany`, `@ManyToOne`, `@OneToOne`, and `@ManyToMany`.

Example (User - Post):

```java
@Entity
public class User {
    @Id @GeneratedValue Long id;
    String username;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    List<Post> posts = new ArrayList<>();
}

@Entity
public class Post {
    @Id @GeneratedValue Long id;
    String title;
    @ManyToOne
    User author;
}
```

Notes
- Prefer DTOs for API responses to avoid lazy-loading and serialization problems.

Exercises
- Implement endpoints to create a `Post` for a `User` and to fetch a user with posts.
