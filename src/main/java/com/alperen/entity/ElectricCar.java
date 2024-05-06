package com.alperen.entity;

import com.alperen.entity.superclasses.Car;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "tbl_electric_car")
@Entity
public class ElectricCar extends Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long electricEngineId;
    @Column(name = "battery_capacity_km")
    private Double batteryCapacity;
    @Column(name = "energy_consumption_kWh/km")
    private Double energyConsumption;



}
