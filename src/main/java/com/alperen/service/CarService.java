package com.alperen.service;

import com.alperen.dto.request.CarCreateRequestDto;
import com.alperen.dto.request.ElectricCarCreateRequestDto;
import com.alperen.dto.request.OrderRequestDto;
import com.alperen.entity.ElectricCar;
import com.alperen.entity.FuelCar;
import com.alperen.entity.HybridCar;
import com.alperen.entity.enums.ECarType;
import com.alperen.entity.superclasses.Car;
import com.alperen.exception.CarDealershipException;
import com.alperen.exception.ErrorType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {
    private final ElectricCarService electricCarService;
    private final HybridCarService hybridCarService;
    private final FuelCarService fuelCarService;

//    public ElectricCar createElectricCar(ElectricCarCreateRequestDto dto) {
//        return electricCarService.createElectricCar(dto);
//    }
//    public List<ElectricCar> createElectricCars(List<ElectricCarCreateRequestDto> dtoList) {
//        return electricCarService.createElectricCars(dtoList);
//    }

    public List<Car> createCars(List<CarCreateRequestDto> dtoList) {
        List<Car> carList = new ArrayList<>();
        List<CarCreateRequestDto> electricCars = new ArrayList<>();
        List<CarCreateRequestDto> hybridCars = new ArrayList<>();
        List<CarCreateRequestDto> fuelCars = new ArrayList<>();

        for (CarCreateRequestDto dto : dtoList) {
            if (dto.getCarType().toString().equals("ELECTRIC")) {
                electricCars.add(dto);
            } else if (dto.getCarType().toString().equals("HYBRID")) {
                hybridCars.add(dto);
            } else {
                fuelCars.add(dto);
            }
        }
        if (!electricCars.isEmpty()) {
            carList.addAll(electricCarService.createElectricCars(electricCars));
        }
        if (!hybridCars.isEmpty()) {
            carList.addAll(hybridCarService.createHybridCars(hybridCars));
        }
        if (!fuelCars.isEmpty()) {
            carList.addAll(fuelCarService.createFuelCars(fuelCars));
        }
        return carList;
    }

    public Optional<Car> findByCarCode(ECarType carType, String carCode) {

        if (carType.toString().equals("ELECTRIC")) {
            return Optional.of(electricCarService.findByCarCode(carCode).get());
        } else if (carType.toString().equals("HYBRID")) {
            return Optional.of(hybridCarService.findByCarCode(carCode).get());
        } else if (carType.toString().equals("FUEL")) {
            return Optional.of(fuelCarService.findByCarCode(carCode).get());
        } else {
            throw new CarDealershipException(ErrorType.CAR_NOT_FOUND);
        }
    }

    public Optional<Car> updateCarStatus(Car car){
        if(car instanceof FuelCar){
           return Optional.ofNullable(fuelCarService.update((FuelCar) car));
        } else if (car instanceof ElectricCar){
            return Optional.ofNullable(electricCarService.update((ElectricCar) car));
        } else {
            return Optional.ofNullable(hybridCarService.update((HybridCar) car));
        }
    }
}
