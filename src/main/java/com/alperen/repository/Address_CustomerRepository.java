package com.alperen.repository;


import com.alperen.entity.Address_Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Address_CustomerRepository extends JpaRepository<Address_Customer,Long> {
}
