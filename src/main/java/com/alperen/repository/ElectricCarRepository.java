package com.alperen.repository;

import com.alperen.entity.ElectricCar;
import com.alperen.entity.FuelCar;
import com.alperen.entity.HybridCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ElectricCarRepository extends JpaRepository<ElectricCar,Long> {
    Optional<ElectricCar> findByCarCode(String carCode);
    List<ElectricCar> findAll();

}
