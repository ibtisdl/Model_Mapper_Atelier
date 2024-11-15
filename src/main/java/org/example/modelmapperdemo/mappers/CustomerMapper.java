package org.example.modelmapperdemo.mappers;

import org.example.modelmapperdemo.dtos.CustomerDTO;
import org.example.modelmapperdemo.dtos.CustomerDtoNew;
import org.example.modelmapperdemo.entities.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    private ModelMapper mapper = new ModelMapper();
    public CustomerDTO fromCustomer(Customer customer){
        return this.mapper.map(customer,CustomerDTO.class);
    }
    public CustomerDtoNew toCustomerDtoNew(Customer customer) {
        return mapper.map(customer, CustomerDtoNew.class);
    }
}
