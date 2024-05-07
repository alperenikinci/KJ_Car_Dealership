package com.alperen.repository;

import com.alperen.entity.Customer;
import com.alperen.entity.HybridEngine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HybridEngineRepository extends JpaRepository<HybridEngine,Long> {
}
