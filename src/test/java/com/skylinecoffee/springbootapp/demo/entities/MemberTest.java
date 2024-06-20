package com.skylinecoffee.springbootapp.demo.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {
    Member member;

    @BeforeEach
    public void setUp(){
        member=new Member();
    }
    @Test
    @DisplayName("Add member email")
    void setEmail() {
        String email="test@email.com";
        member.setEmail(email);
        assertEquals(email,member.getEmail());
    }
}