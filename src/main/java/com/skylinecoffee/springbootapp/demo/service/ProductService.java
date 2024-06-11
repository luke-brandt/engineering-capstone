package com.skylinecoffee.springbootapp.demo.service;

import com.skylinecoffee.springbootapp.demo.entities.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll();
    public Product findById(int theId);
    public void save (Product theProduct);
    public void deleteById(int theId);
    public List<Product> listAll(String keyword);
}
