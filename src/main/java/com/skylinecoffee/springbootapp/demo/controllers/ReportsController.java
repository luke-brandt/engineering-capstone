package com.skylinecoffee.springbootapp.demo.controllers;

import com.skylinecoffee.springbootapp.demo.entities.Location;
import com.skylinecoffee.springbootapp.demo.entities.Member;
import com.skylinecoffee.springbootapp.demo.entities.Product;
import com.skylinecoffee.springbootapp.demo.repository.LocationRepository;
import com.skylinecoffee.springbootapp.demo.repository.MemberRepository;
import com.skylinecoffee.springbootapp.demo.service.ProductService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ReportsController {

    private final MemberRepository memberRepository;
    private ProductService productService;

    private final LocationRepository locationRepository;
    public ReportsController(MemberRepository memberRepository, ProductService productService,LocationRepository locationRepository){
        this.memberRepository = memberRepository;
        this.productService=productService;
        this.locationRepository = locationRepository;
    }

    @GetMapping("/reportsscreen")
    public String showLocations(Model model, @Param("productkeyword") String productkeyword){
        List<Member> members = (List<Member>) memberRepository.findAll();
        model.addAttribute("members", members);
        List<Product> productList=productService.listAll(productkeyword);
        model.addAttribute("products", productList);
        List<Location> locations = (List<Location>) locationRepository.findAll();
        model.addAttribute("locations", locations);
        return "/reportsscreen";
    }
}
