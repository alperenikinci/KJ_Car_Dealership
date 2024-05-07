package com.alperen.entity.superclasses;

import com.alperen.entity.enums.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass
public class Car extends BaseEntity {


    @Enumerated(EnumType.STRING)
    private EBrand brand;
    @Column(nullable = false)
    private String model;
    @Enumerated(EnumType.STRING)
    private EColor color;
    private Integer year;
    private Double price;
    @Builder.Default
    private Boolean isNew = true;
    @Enumerated(EnumType.STRING)
    private EBodyType bodyType;
    @Enumerated(EnumType.STRING)
    private EDrivetrainType drivetrainType;
    private Long mileage;
    @Column(name = "weight_kg")
    private Double weight;
    @Column(name = "top_speed_km/h")
    private Double topSpeed;
    private String carCode;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EStatus status = EStatus.ON_SHOWROOM;
}
