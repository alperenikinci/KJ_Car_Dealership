package com.alperen.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRequestDto {

    private String carCode;
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

}
