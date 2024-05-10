package com.alperen.repository;

import com.alperen.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Optional<Customer> findOptionalByCustomerCitizenshipId(String customerCitizenshipId);
    Boolean existsByCustomerNameAndCustomerSurnameAndCustomerCitizenshipIdAndCustomersEmailAndCustomersPhoneNumber(
            String customerName, String customerSurname, String customerCitizenshipId,
            String customersEmail, String customersPhoneNumber);

}
