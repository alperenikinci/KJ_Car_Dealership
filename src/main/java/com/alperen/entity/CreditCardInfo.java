package com.alperen.entity;

import com.alperen.entity.superclasses.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "tbl_credit_card_info")
public class CreditCardInfo  extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ownersName;
    private String ownersSurname;
    @Column(unique = true)
//    @Size(min = 16, max = 16)
    private String creditCardNo;
    private String creditCardExpirationDate;
//    @Size(min = 3,max = 3)
    private String cvc;
}
