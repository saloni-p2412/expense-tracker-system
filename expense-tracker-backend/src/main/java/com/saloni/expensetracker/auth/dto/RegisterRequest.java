package com.saloni.expensetracker.auth.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    @NotBlank(message="Full Name is Required")
    private String fullName;

    @NotBlank(message="Email is required")
    @Email(message="Email should be valid")
    private String email;

    @NotBlank(message="Password should be required")
    @Size(min=6, message="Password must be at least 6 characters")
    private String password;

    private BigDecimal monthlyIncome;

    private String currency;

}
