package com.alperen.entity;

import com.alperen.entity.superclasses.Car;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "tbl_hybrid_car")
@Entity
public class HybridCar extends Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Long electricEngineId;

    private Long internalCombustionEngineId;

    @Column(name = "battery_capacity_km")
    private Double batteryCapacity;

    @Column(name = "energy_consumption_kWh/km")
    private Double energyConsumption;

    @Column(name = "single_engine_energy_consumption_kWh/km")
    private Double singleEngineEnergyConsumption;

    @Column(name = "fuel_capacity_L")
    private Double fuelCapacity;

    @Column(name = "fuel_consumption_L/km")
    private Double fuelConsumption;

    @Column(name = "single_engine_fuel_consumption_L/km")
    private Double singleEngineFuelConsumption;

}
