package com.skylinecoffee.springbootapp.demo.service;

import com.skylinecoffee.springbootapp.demo.entities.Member;

import java.util.List;

public interface MemberService {
    public List<Member> findAll();
    public Member findById(int theId);
    public void save (Member theProduct);
    public void deleteById(int theId);
    public List<Member> listAll(String keyword);
}
