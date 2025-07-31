package com.example.site.controller;

import com.example.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HelloController {

    private final HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }
    @GetMapping("/hello")
    public void sayHello(HttpServletResponse response) throws IOException {
        response.getWriter().write(helloService.greet());
    }
}
