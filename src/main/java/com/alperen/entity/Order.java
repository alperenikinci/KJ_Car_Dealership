package com.alperen.entity;

import com.alperen.entity.enums.ECarType;
import com.alperen.entity.superclasses.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "tbl_order")
@Entity
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String carCode;
    private ECarType carType;
    private Long customerId;
    //TODO DTO'da bunlar verilecek.
//    private String buyersName;
//    private String buyersSurname;
//    private String buyersIdNumber;
//    @Email
//    private String buyersEmail;
//    private String buyersPhoneNumber;
    private Double transactedAmount;
    @Builder.Default
    private Boolean isTransactionCompleted = false;

    private Long addressId;
    //TODO DTO'da bunlar verilecek.
//    @Column(nullable = false)
//    private String street;
//
//    @Column(nullable = false)
//    private String city;
//
//    @Column(nullable = false)
//    private String apartmentNo;
//
//    @Column(nullable = false)
//    private String postalCode;
//
//    @Column(nullable = false)
//    private String country;
}
