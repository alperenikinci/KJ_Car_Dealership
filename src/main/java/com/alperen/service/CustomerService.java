package com.alperen.service;

import com.alperen.dto.request.OrderRequestDto;
import com.alperen.entity.Address;
import com.alperen.entity.Customer;
import com.alperen.entity.Order;
import com.alperen.repository.AddressRepository;
import com.alperen.repository.CustomerRepository;
import com.alperen.repository.OrderRepository;
import com.alperen.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends ServiceManager<Customer,Long> {

    private final CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository) {
        super(customerRepository);
        this.customerRepository = customerRepository;
    }



}
