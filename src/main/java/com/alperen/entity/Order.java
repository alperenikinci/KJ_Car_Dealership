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
    @Enumerated(EnumType.STRING)
    private ECarType carType;
    private Long addressCustomerId;
    //TODO DTO'da bunlar verilecek.
//    private String buyersName;
//    private String buyersSurname;
//    private String buyersIdNumber;
//    @Email
//    private String buyersEmail;
//    private String buyersPhoneNumber;
    private Double remainingAmount;
    @Builder.Default
    private Boolean isDeliveryCompleted = false;
    @Builder.Default
    private Boolean isPaymentCompleted = false;
    @Builder.Default
    private Boolean isDownPaymentCompleted = false;


}
