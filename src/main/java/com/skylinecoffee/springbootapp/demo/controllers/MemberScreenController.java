package com.skylinecoffee.springbootapp.demo.controllers;

import com.skylinecoffee.springbootapp.demo.entities.Member;
import com.skylinecoffee.springbootapp.demo.entities.Product;
import com.skylinecoffee.springbootapp.demo.service.MemberService;
import com.skylinecoffee.springbootapp.demo.service.MemberServiceImpl;
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

@Controller
public class MemberScreenController {

    @Autowired
    private ApplicationContext context;

    private Member member;

    private static Member member1;

    @GetMapping("/memberSignup")
    public String showFormAddPart(Model theModel) {
        member = new Member();
        member1 = member;
        theModel.addAttribute("member", member);
        return "memberForm";
    }
    @PostMapping("/memberSignup")
    public String submitForm(@Valid @ModelAttribute("member") Member member, BindingResult bindingResult, Model theModel) {
        theModel.addAttribute("member", member);



        if(bindingResult.hasErrors()){
//            MemberService memberService = context.getBean(MemberServiceImpl.class);
//            Member member2=MemberService.findById((int)member.getId());
            return "memberForm";
        }
        else {
            MemberService repo = context.getBean(MemberServiceImpl.class);
            if(member.getId()!=0) {
                Member member2 = repo.findById((int) member.getId());
            }
            repo.save(member);
            return "confirmMember";
        }
    }
}
