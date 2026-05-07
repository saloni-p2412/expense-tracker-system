package com.saloni.expensetracker.auth.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.saloni.expensetracker.auth.dto.RegisterRequest;
import com.saloni.expensetracker.user.entity.User;
import com.saloni.expensetracker.user.entity.UserRole;
import com.saloni.expensetracker.user.repository.UserRepository;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Builder
public class AuthService {
    private  final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String register(RegisterRequest registerRequest) {
        
        if(userRepository.existsByEmail(registerRequest.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        User user = User.builder()
            .fullName(registerRequest.getFullName())
            .email(registerRequest.getEmail())
            .password(passwordEncoder.encode(registerRequest.getPassword()))
            .role(UserRole.USER)
            .monthlyIncome(registerRequest.getMonthlyIncome())
            .currency(registerRequest.getCurrency())
            .build();

        userRepository.save(user);

        return "User registered successfullu";

    }
}
