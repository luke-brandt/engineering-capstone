package com.skylinecoffee.springbootapp.demo.bootstrap;

import com.skylinecoffee.springbootapp.demo.entities.Location;
import com.skylinecoffee.springbootapp.demo.entities.Member;
import com.skylinecoffee.springbootapp.demo.entities.Product;
import com.skylinecoffee.springbootapp.demo.repository.LocationRepository;
import com.skylinecoffee.springbootapp.demo.repository.MemberRepository;
import com.skylinecoffee.springbootapp.demo.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final LocationRepository locationRepository;

    private final MemberRepository memberRepository;

    public BootStrapData(ProductRepository productRepository, LocationRepository locationRepository, MemberRepository memberRepository) {

        this.productRepository = productRepository;
        this.locationRepository = locationRepository;
        this.memberRepository = memberRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        long productCount = productRepository.count();

        Product dark = new Product("Dark Roast","Ground", 11.0, 5);
        Product medium= new Product("Medium Roast","Ground",11.0,5);
        Product light= new Product("Light Roast", "Ground",10.0,5);
        Product lightC= new Product("Coconut Light Roast", "Ground",10.0,5);
        Product mediumC= new Product("Caramel Medium Roast","Ground",11.0,5);
        Product darkC = new Product("Chocolate Dark Roast","Ground", 11.0, 5);
        Product caramel= new Product("Caramel Blend","Whole Bean",9.0,5);
        Product chocolate= new Product("Chocolate Blend","Whole Bean",5.0,5);
        Product vanilla= new Product("French Vanilla Blend","Whole Bean",8.0,5);
        Product coconut= new Product("Coconut Blend","Whole Bean",5.0,5);
        productRepository.save(dark);
        productRepository.save(medium);
        productRepository.save(light);
        productRepository.save(darkC);
        productRepository.save(mediumC);
        productRepository.save(lightC);
        productRepository.save(caramel);
        productRepository.save(chocolate);
        productRepository.save(vanilla);
        productRepository.save(coconut);

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

        Member member1 = new Member("Sam", "White", "samwhite@email.com", "1600 5th Ave", "Seattle", "Washington", "98101");
        Member member2 = new Member("John", "Doe", "johndoe@email.com", "123 Main St", "New York", "New York", "10001");
        Member member3 = new Member("Alice", "Johnson", "alice.johnson@email.com", "456 Elm St", "Los Angeles", "California", "90001");
        Member member4 = new Member("Michael", "Smith", "michael.smith@email.com", "789 Oak St", "Chicago", "Illinois", "60601");
        Member member5 = new Member("Emily", "Brown", "emily.brown@email.com", "101 Pine St", "San Francisco", "California", "94101");
        Member member6 = new Member("Daniel", "Lee", "daniel.lee@email.com", "555 Cedar St", "Boston", "Massachusetts", "02101");
        Member member7 = new Member("Sophia", "Martinez", "sophia.martinez@email.com", "777 Maple St", "Houston", "Texas", "77001");
        Member member8 = new Member("Oliver", "Garcia", "oliver.garcia@email.com", "888 Walnut St", "Miami", "Florida", "33101");
        Member member9 = new Member("Isabella", "Lopez", "isabella.lopez@email.com", "999 Birch St", "Phoenix", "Arizona", "85001");
        Member member10 = new Member("William", "Wilson", "william.wilson@email.com", "222 Pineapple St", "Denver", "Colorado", "80201");


        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
        memberRepository.save(member4);
        memberRepository.save(member5);
        memberRepository.save(member6);
        memberRepository.save(member7);
        memberRepository.save(member8);
        memberRepository.save(member9);
        memberRepository.save(member10);




        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());

    }
}
