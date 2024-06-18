package com.skylinecoffee.springbootapp.demo.controllers;


import com.skylinecoffee.springbootapp.demo.entities.Product;
import com.skylinecoffee.springbootapp.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class BuyProductController {

    @Autowired
    private ProductRepository productRepository;


    @GetMapping("/buyProduct")
    public String buyProduct(Model theModel, @RequestParam("productID") Long theId){


        String buyView = "";
        Optional<Product> optional = productRepository.findById(theId);


        if(optional.isPresent()){
            Product tempProduct = optional.get();
            theModel.addAttribute("product", tempProduct);

            int inventoryAmount = tempProduct.getInv();

            if(inventoryAmount > 0){
                inventoryAmount -= 1;
                tempProduct.setInv(inventoryAmount);
                productRepository.save(tempProduct);
                buyView = "confirmbuyproduct";
            }
            else{
                buyView = "errorbuyproduct";
            }
        }

        return buyView;
    }


}
