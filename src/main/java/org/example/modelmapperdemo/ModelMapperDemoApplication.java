package org.example.modelmapperdemo;

import org.example.modelmapperdemo.dtos.CustomerDTO;
import org.example.modelmapperdemo.dtos.CustomerDtoNew;
import org.example.modelmapperdemo.entities.Customer;
import org.example.modelmapperdemo.mappers.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class ModelMapperDemoApplication {
@Autowired
private CustomerMapper customerMapper;
    public static void main(String[] args) {
        SpringApplication.run(ModelMapperDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner start() {
        return args -> {
            List<Customer> customers = new ArrayList<>();

            customers.add(Customer.builder().name("Ibtissam").email("ibtissam@gmail.com").password("1234").build());
            customers.add(Customer.builder().name("Maroua").email("maroua@gmail.com").password("5678").build());
            customers.add(Customer.builder().name("Hiba").email("hiba@gmail.com").password("91011").build());


            List<CustomerDTO> customerDTOs = customers.stream()
                    .map(customerMapper::fromCustomer)
                    .toList();

            System.out.println("List of CustomerDTO:");
            customerDTOs.forEach(System.out::println);

            // Convertir en CustomerDtoNew
            List<CustomerDtoNew> customerDtoNewList = customers.stream()
                    .map(customerMapper::toCustomerDtoNew)
                    .collect(Collectors.toList());

            System.out.println("List of CustomerDtoNew:");
            customerDtoNewList.forEach(System.out::println);        };
    }
}
