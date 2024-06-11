package com.skylinecoffee.springbootapp.demo.bootstrap;

import com.skylinecoffee.springbootapp.demo.entities.Product;
import com.skylinecoffee.springbootapp.demo.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner {

    private final ProductRepository productRepository;

    public BootStrapData(ProductRepository productRepository) {

        this.productRepository = productRepository;
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





        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());

    }
}
