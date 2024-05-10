package com.alperen.repository;

import com.alperen.entity.Customer;
import com.alperen.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    Optional<Order> findByCarCode(String carCode);
}
