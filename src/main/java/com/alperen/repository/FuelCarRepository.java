package com.alperen.repository;

import com.alperen.entity.FuelCar;
import com.alperen.entity.HybridCar;
import com.alperen.entity.InternalCombustionEngine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuelCarRepository extends JpaRepository<FuelCar,Long> {

    Optional<FuelCar> findByCarCode(String carCode);

}
