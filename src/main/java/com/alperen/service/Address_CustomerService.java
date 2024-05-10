package com.alperen.service;

import com.alperen.entity.Address_Customer;
import com.alperen.repository.Address_CustomerRepository;
import com.alperen.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Address_CustomerService extends ServiceManager<Address_Customer,Long> {

    private final Address_CustomerRepository addressCustomerRepository;
    public Address_CustomerService(Address_CustomerRepository addressCustomerRepository) {
        super(addressCustomerRepository);
        this.addressCustomerRepository = addressCustomerRepository;
    }

    public Optional<Address_Customer> findByAddressIdAndCustomerId(Long addressId, Long customerId){
        return addressCustomerRepository.findByAddressIdAndCustomerId(addressId,customerId);
    }

    private Boolean doesAddressCustomerExists(Address_Customer addressCustomer){
        return addressCustomerRepository.existsByAddressIdAndCustomerId(addressCustomer.getAddressId(),addressCustomer.getCustomerId());
    }

    public Address_Customer saveIfNotExists(Address_Customer addressCustomer){
        if (!doesAddressCustomerExists(addressCustomer)) {
            save(addressCustomer);
        } else {
            addressCustomer = findByAddressIdAndCustomerId(addressCustomer.getId(), addressCustomer.getCustomerId()).get();
        }
        return addressCustomer;
    }




}
