package com.dev.backendspring;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*
 * This is a REST Controller in Spring Boot.
 * It handles HTTP requests and returns responses (usually JSON or text).
 *
 * Base URL: /api
 * Endpoint: /api/hello
 *
 * When a request comes to /api/hello,
 * Spring Boot automatically calls the hello() method.
 */

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Spring Boot 👋";
    }
}