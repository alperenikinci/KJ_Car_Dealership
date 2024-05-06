package com.alperen.entity;

import com.alperen.entity.superclasses.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "tbl_address")
@Entity
public class Address extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String street;
    
    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String apartmentNo;
    
    @Column(nullable = false)
    private String postalCode;
    
    @Column(nullable = false)
    private String country;

    @Builder.Default
    private Boolean isAddressVerified = false;
}
