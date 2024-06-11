package com.skylinecoffee.springbootapp.demo.controllers;

import com.skylinecoffee.springbootapp.demo.entities.Product;
import com.skylinecoffee.springbootapp.demo.service.ProductService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 *
 *
 *
 *
 */

@Controller
public class AdminScreenController {

    private ProductService productService;
    private List<Product> theProducts;

    public AdminScreenController(ProductService productService){
        this.productService=productService;
    }
    @GetMapping("/adminscreen")
    public String listPartsandProducts(Model theModel, @Param("productkeyword") String productkeyword){

        List<Product> productList=productService.listAll(productkeyword);
        theModel.addAttribute("products", productList);
        theModel.addAttribute("productkeyword",productkeyword);
        return "adminscreen";
    }
}
