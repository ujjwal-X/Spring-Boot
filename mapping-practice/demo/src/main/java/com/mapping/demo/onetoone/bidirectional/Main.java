package com.mapping.demo.onetoone.unidirectonal;

import com.mapping.demo.onetoone.unidirectonal.entity.AddressEntity;
import com.mapping.demo.onetoone.unidirectonal.entity.CustomerEntity;
//import com.mapping.demo.onetoone.unidirectonal.repository.AddressRepo;
import com.mapping.demo.onetoone.unidirectonal.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;

@SpringBootApplication(scanBasePackages = "com.mapping.demo.onetoone.unidirectonal")
public class Main {

    @Autowired
    private CustomerRepo customerRepo;

//    @Autowired
//    private AddressRepo addressRepo;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);

        Main mainApp = context.getBean(Main.class);
        mainApp.run();
    }

    public void run() {
        // Create Address and Customer instances
        AddressEntity address1 = new AddressEntity();
        address1.setStreetName("Ranjeet Hanuman");
        address1.setStreetNo("101");

        CustomerEntity customer1 = new CustomerEntity();
//        customer1.setId(50);
        customer1.setName("Vishal Panwar");
        customer1.setAddressEntity(address1);


        AddressEntity address2 = new AddressEntity();
        address2.setStreetName("MR10");
        address2.setStreetNo("102");

        CustomerEntity customer2 = new CustomerEntity();
        customer2.setName("Manish");
        customer2.setAddressEntity(address2);


        AddressEntity address3 = new AddressEntity();
        address3.setStreetName("Scheme 54");
        address3.setStreetNo("103");

        CustomerEntity customer3 = new CustomerEntity();
//        customer3.setId(10);
        customer3.setName("Shubham");
        customer3.setAddressEntity(address3);

        AddressEntity address4 = new AddressEntity();
        address4.setStreetName("Scheme 55");
        address4.setStreetNo("103");

        CustomerEntity customer4 = new CustomerEntity();

        customer4.setName("Karan");
        customer4.setAddressEntity(address4);

//        addressRepo.save(address1);
//        addressRepo.save(address2);
//        addressRepo.save(address3);
//        addressRepo.save(address4);

        customerRepo.save(customer1);
        customerRepo.save(customer2);
        customerRepo.save(customer3);
        customerRepo.save(customer4);


        System.out.println("Customers saved successfully!");
    }
}
