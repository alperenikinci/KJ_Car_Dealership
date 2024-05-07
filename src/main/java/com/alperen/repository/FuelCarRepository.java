package com.alperen.repository;

import com.alperen.entity.FuelCar;
import com.alperen.entity.InternalCombustionEngine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelCarRepository extends JpaRepository<FuelCar,Long> {
}
