package com.alperen.entity;

import com.alperen.entity.superclasses.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "tbl_customer")
@Entity
public class Customer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String customerSurname;
    private String customersIdNumber;
    @Email
    private String customersEmail;
    private String customersPhoneNumber;
    @Builder.Default
    private Boolean isCustomerVerified = false;
    //TODO Address ile Customer arasında normalizasyon yapılacak. DONE
}
