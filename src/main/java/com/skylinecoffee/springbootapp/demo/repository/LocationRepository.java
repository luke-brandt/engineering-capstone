package com.skylinecoffee.springbootapp.demo.repository;

import com.skylinecoffee.springbootapp.demo.entities.Location;
import com.skylinecoffee.springbootapp.demo.entities.Product;
import jakarta.servlet.http.Part;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationRepository extends CrudRepository <Location,Long> {
    @Query("SELECT l FROM Location l WHERE l.address LIKE %?1%")
    public List<Location> search(String keyword);
}
