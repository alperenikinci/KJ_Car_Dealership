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

    //Car info
    private String carCode;
    private ECarType carType;

    //Customer info
    private String customerName;
    private String customerSurname;
    private String customersIdNumber;
    @Email
    private String customersEmail;
    private String customersPhoneNumber;

    //Payment info
    private Double transactedAmount;

    //Address info
    private String street;
    private String city;
    private String apartmentNo;
    private String postalCode;
    private String country;


}
