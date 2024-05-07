package com.alperen.service;

import com.alperen.entity.Address;
import com.alperen.entity.Address_Customer;
import com.alperen.repository.AddressRepository;
import com.alperen.repository.Address_CustomerRepository;
import com.alperen.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class Address_CustomerService extends ServiceManager<Address_Customer,Long> {

    private final Address_CustomerRepository addressCustomerRepository;
    public Address_CustomerService(Address_CustomerRepository addressCustomerRepository) {
        super(addressCustomerRepository);
        this.addressCustomerRepository = addressCustomerRepository;
    }



}
