package com.alperen.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {

    INTERNAL_SERVER_ERROR(5100, "Sunucu Hatasi",HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST (4100,"Parametre hatasi", HttpStatus.BAD_REQUEST),
    CAR_NOT_FOUND (6100,"Arac bulunamadi!", HttpStatus.NOT_FOUND),
    DOWN_PAYMENT_NOT_SUFFICIENT (7100,"Kapora miktari yeterli degil", HttpStatus.BAD_REQUEST),
    PAYMENT_ALREADY_COMPLETED(7110,"Odeme zaten tamamlanmis" ,HttpStatus.BAD_REQUEST ),
    ADDRESS_NOT_FOUND(6110,"Address bulunamadi. Lutfen address bilgilerinizi guncelleyin" ,HttpStatus.NOT_FOUND ),
    ORDER_NOT_FOUND(6120,"Siparis bulunamadi. Lutfen siparis kodunuzu kontrol ediniz" ,HttpStatus.NOT_FOUND );




    private int code;
    private String message;
    private HttpStatus httpStatus;
}