package com.example.microservicesdemo.usermanagementservice.user.service;

import com.example.microservicesdemo.usermanagementservice.user.dto.UserProfile;
import com.example.microservicesdemo.usermanagementservice.user.model.User;
import com.example.microservicesdemo.usermanagementservice.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    public UserProfile getUserProfile(User user) {
        return new UserProfile(user.getUsername(), user.getRole(), user.getStatus());
    }

}
