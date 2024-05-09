package com.alperen.repository;


import com.alperen.entity.Address_Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Address_CustomerRepository extends JpaRepository<Address_Customer,Long> {
    Optional<Address_Customer> findByAddressIdAndCustomerId(Long addressId, Long customerId);
    Boolean existsByAddressIdAndCustomerId(Long addressId,Long customerId);
}
