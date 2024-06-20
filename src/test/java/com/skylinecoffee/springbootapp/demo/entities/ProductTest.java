package com.skylinecoffee.springbootapp.demo.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product product;
    @BeforeEach
    public void setUp(){
        product=new Product();
    }

    @Test
    @DisplayName("Gets product name")
    void getName() {
        String name="test product";
        product.setName(name);
        assertEquals(name,product.getName());
    }

    @Test
    @DisplayName("Adds product name")
    void setName() {
        String name="test product";
        product.setName(name);
        assertEquals(name,product.getName());
    }

    @Test
    @DisplayName("Gets product inventory")
    void getInv() {
        int inv=5;
        product.setInv(inv);
        assertEquals(inv,product.getInv());
    }

    @Test
    @DisplayName("Adds product inventory")
    void setInv() {
        int inv=5;
        product.setInv(inv);
        assertEquals(inv,product.getInv());
    }
}