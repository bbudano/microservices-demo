package com.example.microservicesdemo.usermanagementservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {

    @GetMapping("/test")
    String test() {
        return "Hello from user-management-service";
    }

}
