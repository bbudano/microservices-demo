package com.example.microservicesdemo.usermanagementservice;

import com.example.microservicesdemo.usermanagementservice.user.model.User;
import com.example.microservicesdemo.usermanagementservice.user.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableDiscoveryClient
@SpringBootApplication
public class UserManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementServiceApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			var user = new User();
			user.setEmail("admin@demo.com");
			user.setPassword(passwordEncoder.encode("admin"));
			user.setRole(User.Role.ROLE_ADMIN);
			user.setStatus(User.Status.ACTIVE);

			userRepository.save(user);
		};
	}

}
