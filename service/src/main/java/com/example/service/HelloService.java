package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String greet() {
        return "Hello, Jakarta EE + Tomcat 10 + Spring Framework!";
    }
}
