package com.alperen.dto.request;

import com.alperen.entity.enums.ECarType;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequestDto {

    private String carCode;
    private ECarType carType;
    private String buyersName;
    private String buyersSurname;
    private String buyersIdNumber;
    @Email
    private String buyersEmail;
    private String buyersPhoneNumber;
    private Double transactedAmount;

    private String street;
    private String city;
    private String apartmentNo;
    private String postalCode;
    private String country;


}
