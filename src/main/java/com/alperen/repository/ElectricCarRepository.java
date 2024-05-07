package com.alperen.repository;

import com.alperen.entity.ElectricCar;
import com.alperen.entity.FuelCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectricCarRepository extends JpaRepository<ElectricCar,Long> {
}
