package com.alperen.dto.request;

import com.alperen.entity.enums.ECarType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    private String customerCitizenshipId;
    @Email
    private String customersEmail;
    private String customersPhoneNumber;

    //Payment info
    @NotBlank
    private String ownersName;
    @NotBlank
    private String ownersSurname;
    @Size(min = 16,max = 16)
    private String creditCardNo;
    @Size(min = 5,max = 5)
    private String creditCardExpirationDate; //TODO Date formatter ile değiştirilebilir.
    @Size(min = 3,max = 3)
    private String cvc;
    private Double paymentAmount;

    //Address info
    private String street;
    private String city;
    private String apartmentNo;
    private String postalCode;
    private Long countryId;

}
