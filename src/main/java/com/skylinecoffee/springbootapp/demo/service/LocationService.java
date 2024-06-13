package com.skylinecoffee.springbootapp.demo.service;

import com.skylinecoffee.springbootapp.demo.entities.Location;

import java.util.List;

public interface LocationService {
    public List<Location> findAll();
    public Location findById(int theId);
    public void save (Location theLocation);
    public void deleteById(int theId);
    public List<Location> listAll(String keyword);
}
