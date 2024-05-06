package com.alperen.entity;

import com.alperen.entity.superclasses.Engine;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "tbl_electric_engine")
@Entity
public class ElectricEngine extends Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "charging_time_m")
    private Integer chargingTime;

}
