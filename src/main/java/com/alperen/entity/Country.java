package com.alperen.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_country")
@Entity
public class Country {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String name;
    
    @Column(nullable = false)
    private String isoCode;
    
    @Column(nullable = false)
    private String capital;
    
    @Column(nullable = false)
    private String continent;
    
    @Column(nullable = false)
    private String region;
    

    

}
