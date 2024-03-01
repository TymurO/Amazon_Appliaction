package com.tymuro.amazontestapplication.security;

import com.tymuro.amazontestapplication.models.UserEntity;
import com.tymuro.amazontestapplication.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserEntity create(UserEntity user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username is taken");
        }

        return userRepository.save(user);
    }

    public UserEntity getUserByUsername(String username) {
        return userRepository.findUserEntityByUsername(username).orElse(null);
    }

    public UserDetailsService userDetailsService() {
        return this::getUserByUsername;
    }

    public UserEntity getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByUsername(username);
    }
}
