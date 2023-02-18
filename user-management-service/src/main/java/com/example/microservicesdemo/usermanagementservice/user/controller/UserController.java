package com.example.microservicesdemo.usermanagementservice.user.controller;

import com.example.microservicesdemo.usermanagementservice.user.dto.UserProfile;
import com.example.microservicesdemo.usermanagementservice.user.model.User;
import com.example.microservicesdemo.usermanagementservice.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/profile")
    UserProfile test(Authentication authentication) {
        var user = (User) authentication.getPrincipal();

        return userService.getUserProfile(user);
    }

}
