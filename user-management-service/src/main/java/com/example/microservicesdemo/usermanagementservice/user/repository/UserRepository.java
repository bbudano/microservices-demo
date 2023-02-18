package com.example.microservicesdemo.usermanagementservice.user.repository;

import com.example.microservicesdemo.usermanagementservice.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}
