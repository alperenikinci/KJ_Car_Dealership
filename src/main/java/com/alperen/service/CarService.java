package com.alperen.service;

import com.alperen.dto.request.CarCreateRequestDto;
import com.alperen.dto.request.ElectricCarCreateRequestDto;
import com.alperen.entity.ElectricCar;
import com.alperen.entity.superclasses.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

       for (CarCreateRequestDto dto : dtoList){
           if(dto.getCarType().toString().equals("ELECTRIC")){
               electricCars.add(dto);
           } else if(dto.getCarType().toString().equals("HYBRID")){
               hybridCars.add(dto);
           } else {
               fuelCars.add(dto);
           }
       }
       if (!electricCars.isEmpty()){
          carList.addAll(electricCarService.createElectricCars(electricCars));
       }
       if(!hybridCars.isEmpty()){
           carList.addAll(hybridCarService.createHybridCars(hybridCars));
       }
       if(!fuelCars.isEmpty()){
           carList.addAll(fuelCarService.createFuelCars(fuelCars));
       }
       return carList;
    }
}
