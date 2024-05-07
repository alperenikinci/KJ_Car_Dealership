package com.alperen.entity.superclasses;

import com.alperen.entity.enums.EBrand;
import com.alperen.entity.enums.EFuelType;
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
@MappedSuperclass
public class Engine extends BaseEntity {

    private String name;
    @Column(name = "horse_power_hp")
    private Long horsePower;
    @Column(name = "torque_Nm")
    private Double torque;
    @Enumerated(EnumType.STRING)
    private EFuelType fuelType;
    @Enumerated(EnumType.STRING)
    private EBrand brand;


}