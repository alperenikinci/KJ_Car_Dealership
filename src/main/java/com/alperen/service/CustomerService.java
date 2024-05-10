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

import java.util.Optional;

@Service
public class CustomerService extends ServiceManager<Customer,Long> {

    private final CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository) {
        super(customerRepository);
        this.customerRepository = customerRepository;
    }

    public Optional<Customer> findByCustomerCitizenshipId(String customerCitizenshipId){
        return customerRepository.findOptionalByCustomerCitizenshipId(customerCitizenshipId);
    }

    private Boolean doesCustomerExist(Customer customer) {
        return customerRepository.existsByCustomerNameAndCustomerSurnameAndCustomerCitizenshipIdAndCustomersEmailAndCustomersPhoneNumber(
                customer.getCustomerName(), customer.getCustomerSurname(), customer.getCustomerCitizenshipId(),
                customer.getCustomersEmail(), customer.getCustomersPhoneNumber());
    }

    public Customer saveAndVerifyCustomerIfNotExists(Customer customer){
        if (!doesCustomerExist(customer)) {
            save(customer);
        } else {
            customer =findByCustomerCitizenshipId(customer.getCustomerCitizenshipId()).get();
        }
        customer.setIsCustomerVerified(true);
        return customer;
    }



}
