# Week 6 — Building REST APIs

Overview
- Design RESTful endpoints using `@RestController`, proper HTTP verbs, and status codes.

Quick tip
- Keep controllers thin: delegate business logic to services.

Minimal controller example:

```java
@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientService svc;
    public ClientController(ClientService svc) { this.svc = svc; }

    @GetMapping
    public List<Client> list() { return svc.findAll(); }

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody @Valid ClientDto dto) {
        Client created = svc.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
```

Exercises
- Add `ClientDto` with validation annotations and wire `@Valid` in controller methods.
- Add integration tests using MockMvc.
