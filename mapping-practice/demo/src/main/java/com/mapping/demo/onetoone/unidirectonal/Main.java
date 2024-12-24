package com.mapping.demo.onetoone.embeded;

import com.mapping.demo.onetoone.embeded.entity.AddressEntity;
import com.mapping.demo.onetoone.embeded.entity.CustomerEntity;
import com.mapping.demo.onetoone.embeded.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;

@SpringBootApplication(scanBasePackages = "com.mapping.demo.onetoone.embeded")
public class Main {

    @Autowired
    private CustomerRepo customerRepo;

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
        customer3.setName("Shubham");
        customer3.setAddressEntity(address3);

        // Save customers
        ArrayList<CustomerEntity> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

        customerRepo.saveAll(customers);

        System.out.println("Customers saved successfully!");
    }
}
