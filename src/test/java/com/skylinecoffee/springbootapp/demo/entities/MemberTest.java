package com.skylinecoffee.springbootapp.demo.entities;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {
    Member member;

    private Validator validator;

    @BeforeEach
    public void setUp(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    @DisplayName("Validate email field with valid email")
    public void testValidEmail() {
        Member member = new Member();
        member.setEmail("test@example.com");

        var violations = validator.validate(member);

        long emailViolationsCount = violations.stream()
                .filter(violation -> violation.getPropertyPath().toString().equals("email"))
                .count();


        assertEquals(0, emailViolationsCount, "Expected no validation errors for the email field");
    }
    @Test
    @DisplayName("Validate email field with invalid email")
    public void testInvalidEmail() {
        Member member = new Member();
        member.setEmail("invalid-email");

        var violations = validator.validate(member);

        long emailViolationsCount = violations.stream()
                .filter(violation -> violation.getPropertyPath().toString().equals("email"))
                .count();

        violations.stream()
                .filter(violation -> violation.getPropertyPath().toString().equals("email"))
                .forEach(violation -> {
                    System.out.println("Email validation error: " + violation.getMessage());
                });

        assertEquals(1, emailViolationsCount, "Expected one validation errors for the email field");
    }

    @Test
    @DisplayName("Validate email field with empty email")
    public void testEmptyEmail() {
        Member member = new Member();
        member.setEmail("");

        var violations = validator.validate(member);

        long emailViolationsCount = violations.stream()
                .filter(violation -> violation.getPropertyPath().toString().equals("email"))
                .count();

        violations.stream()
                .filter(violation -> violation.getPropertyPath().toString().equals("email"))
                .forEach(violation -> {
                    System.out.println("Email validation error: " + violation.getMessage());
                });

        assertEquals(1, emailViolationsCount, "Expected one validation errors for the email field");
    }
}