package com.alperen.repository;

import com.alperen.entity.ElectricEngine;
import com.alperen.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectricEngineRepository extends JpaRepository<ElectricEngine,Long> {
}
