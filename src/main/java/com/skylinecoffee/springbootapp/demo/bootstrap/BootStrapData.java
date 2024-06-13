package com.skylinecoffee.springbootapp.demo.bootstrap;

import com.skylinecoffee.springbootapp.demo.entities.Location;
import com.skylinecoffee.springbootapp.demo.entities.Product;
import com.skylinecoffee.springbootapp.demo.repository.LocationRepository;
import com.skylinecoffee.springbootapp.demo.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final LocationRepository locationRepository;

    public BootStrapData(ProductRepository productRepository, LocationRepository locationRepository) {

        this.productRepository = productRepository;
        this.locationRepository = locationRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        long productCount = productRepository.count();

        Product dark = new Product("Dark Roast","Ground", 11.0, 5);
        Product medium= new Product("Medium Roast","Ground",11.0,5);
        Product light= new Product("Light Roast", "Ground",10.0,5);
        Product caramel= new Product("Caramel Blend","Whole Bean",9.0,5);
        Product chocolate= new Product("Chocolate Blend","Whole Bean",5.0,5);
        productRepository.save(dark);
        productRepository.save(medium);
        productRepository.save(light);
        productRepository.save(caramel);
        productRepository.save(chocolate);

        Location location1 = new Location("1600 5th Ave", "Seattle", "Washington", "98101");
        Location location2 = new Location("901 12th Ave", "Seattle", "Washington", "98122");
        Location location3 = new Location("123 Main St", "Portland", "Oregon", "97201");
        Location location4 = new Location("456 Elm St", "Portland", "Oregon", "97202");
        Location location5 = new Location("789 Oak St", "Boise", "Idaho", "83702");
        Location location6 = new Location("321 Pine St", "Boise", "Idaho", "83703");
        locationRepository.save(location1);
        locationRepository.save(location2);
        locationRepository.save(location3);
        locationRepository.save(location4);
        locationRepository.save(location5);
        locationRepository.save(location6);







        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());

    }
}
