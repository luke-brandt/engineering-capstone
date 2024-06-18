package com.skylinecoffee.springbootapp.demo.service;

import com.skylinecoffee.springbootapp.demo.entities.Member;
import com.skylinecoffee.springbootapp.demo.entities.Product;
import com.skylinecoffee.springbootapp.demo.repository.MemberRepository;
import com.skylinecoffee.springbootapp.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService{

    private MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> findAll() {
        return (List<Member>) memberRepository.findAll();
    }

    public Member findById(int theId){
        Long theIdl=(long)theId;
        Optional<Member> result = memberRepository.findById(theIdl);

        Member theMember = null;

        if (result.isPresent()) {
            theMember = result.get();
        }
        else {
            // we didn't find the product id
            throw new RuntimeException("Did not find member id - " + theId);
        }

        return theMember;
    }

    public void save(Member theMember){
        memberRepository.save(theMember);
    }

    @Override
    public void deleteById(int theId) {
        Long theIdl=(long)theId;
        memberRepository.deleteById(theIdl);
    }

    @Override
    public List<Member> listAll(String keyword) {
        return null;
    }
//    public List<Member> listAll(String keyword){
//        if(keyword !=null){
//            return memberRepository.search(keyword);
//        }
//        return (List<Member>) memberRepository.findAll();
//    }
}
