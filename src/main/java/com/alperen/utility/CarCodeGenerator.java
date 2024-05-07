package com.alperen.utility;

import com.alperen.entity.ElectricCar;
import com.alperen.entity.enums.EBrand;
import com.alperen.entity.superclasses.Car;

import java.util.*;

//TODO Rename to -> CarCodeGenerator
public class CarCodeGenerator {


    public static String generateCarCode(String batchNumber, Car car) {

        String initials = car.getBrand().getInitials();
        String modelInitials = null;
        if (car.getModel().length() == 1) {
            modelInitials = (car.getModel() + car.getModel()).toUpperCase();
        } else {
            modelInitials = car.getModel().toUpperCase().substring(0, 2);
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(initials + "-" + modelInitials + "-");
        stringBuilder.append(batchNumber);
        stringBuilder.append("-");
        stringBuilder.append(generateCode());

        return stringBuilder.toString();
    }

    public static String generateCode() {
        UUID uuid = UUID.randomUUID();
        // UUID'yi al ve '-' karakterlerini kaldır
        String uniqueCode = uuid.toString().replaceAll("-", "");
        // 50 karakterlik bir kısmını al, daha fazla karakter varsa kırp
        return uniqueCode.substring(0, 20).toUpperCase();
    }

    public static String generateBatchNumber() {
        UUID uuid = UUID.randomUUID();
        String uniqueCode = uuid.toString().replaceAll("-", "").toUpperCase();
        char[] charArr = new char[2];
        int charIndex = 0;
        for (int i = 0; i < uniqueCode.length(); i++) {
            int asciiValue = uniqueCode.charAt(i);
            if (asciiValue >= 65 && asciiValue <= 90) {
                charArr[charIndex] = (char) asciiValue;
                charIndex++;
            }
            if (charIndex == 2) {
                break;
            }
        }
        return String.valueOf(charArr);
    }
}