package com.skylinecoffee.springbootapp.demo.repository;

import com.skylinecoffee.springbootapp.demo.entities.Member;
import com.skylinecoffee.springbootapp.demo.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MemberRepository extends CrudRepository<Member,Long> {
//    @Query("SELECT m FROM Member m WHERE m.name LIKE %?1%")
//    public List<Product> search(String keyword);
}
