package com.skylinecoffee.springbootapp.demo.controllers;


import com.skylinecoffee.springbootapp.demo.entities.Product;
import com.skylinecoffee.springbootapp.demo.service.ProductService;
import com.skylinecoffee.springbootapp.demo.service.ProductServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *
 *
 */
@Controller
public class AddProductController {
    @Autowired
    private ApplicationContext context;
    private static Product product1;
    private Product product;

    @GetMapping("/showFormAddProduct")
    public String showFormAddPart(Model theModel) {
        product = new Product();
        product1=product;
        theModel.addAttribute("product", product);
        return "productForm";
    }

    @PostMapping("/showFormAddProduct")
    public String submitForm(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model theModel) {
        theModel.addAttribute("product", product);



        if(bindingResult.hasErrors()){
            ProductService productService = context.getBean(ProductServiceImpl.class);
            return "productForm";
        }
        else {
            ProductService repo = context.getBean(ProductServiceImpl.class);
            repo.save(product);
            return "confirmationaddproduct";
        }
    }

    @GetMapping("/showProductFormForUpdate")
    public String showProductFormForUpdate(@RequestParam("productID") int theId, Model theModel) {
        ProductService repo = context.getBean(ProductServiceImpl.class);
        Product theProduct = repo.findById(theId);
        product1=theProduct;
    //    this.product=product;
        //set the employ as a model attibute to prepopulate the form
        theModel.addAttribute("product", theProduct);
        //send over to our for
        return "productForm";
    }

    @GetMapping("/deleteproduct")
    public String deleteProduct(@RequestParam("productID") int theId, Model theModel) {
        ProductService productService = context.getBean(ProductServiceImpl.class);
        Product product2=productService.findById(theId);
        productService.save(product2);
        productService.deleteById(theId);

        return "confirmationdeleteproduct";
    }
}
