package com.alperen.entity;

import com.alperen.entity.superclasses.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "tbl_customer")
@Entity
public class Customer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String buyersName;
    private String buyersSurname;
    private Long countryId;
    private String buyersIdNumber;
    @Email
    private String buyersEmail;
    private String buyersPhoneNumber;
    @Builder.Default
    private Boolean isCustomerVerified = false;
    //TODO Address ile Customer arasında normalizasyon yapılacak.
}
