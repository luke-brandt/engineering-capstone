package com.skylinecoffee.springbootapp.demo.controllers;

import com.skylinecoffee.springbootapp.demo.entities.Location;
import com.skylinecoffee.springbootapp.demo.repository.LocationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LocationScreenController {
    private final LocationRepository locationRepository;

    public LocationScreenController(LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }
    @GetMapping("/locationscreen")
    public String showLocations(Model model){
        List<Location> locations = (List<Location>) locationRepository.findAll();
        model.addAttribute("locations", locations);
        return "/locationscreen";
    }
}
