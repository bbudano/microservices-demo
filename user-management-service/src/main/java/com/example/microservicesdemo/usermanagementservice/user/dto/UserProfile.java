package com.example.microservicesdemo.usermanagementservice.user.dto;

import com.example.microservicesdemo.usermanagementservice.user.model.User;

public record UserProfile(String email, User.Role role, User.Status status) {
}
