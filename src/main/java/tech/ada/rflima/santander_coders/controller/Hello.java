package tech.ada.rflima.santander_coders.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Hello {

    @GetMapping
    public String hello() {
        return "Hello!";
    }
}
