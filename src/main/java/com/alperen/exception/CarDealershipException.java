package com.alperen.exception;

import lombok.Getter;



@Getter
public class CarDealershipException extends RuntimeException{

    private final ErrorType errorType;

    public CarDealershipException(ErrorType errorType, String customMessage){
        super(customMessage);
        this.errorType = errorType;
    }
    public CarDealershipException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }
}