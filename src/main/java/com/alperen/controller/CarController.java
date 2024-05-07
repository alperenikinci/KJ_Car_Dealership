package com.alperen.controller;

import com.alperen.dto.request.CarCreateRequestDto;
import com.alperen.dto.request.ElectricCarCreateRequestDto;
import com.alperen.entity.ElectricCar;
import com.alperen.entity.superclasses.Car;
import com.alperen.service.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    @PostMapping("/create")
    public ResponseEntity<List<Car>> createCars(@RequestBody @Valid List<CarCreateRequestDto> dto){
        return ResponseEntity.ok(carService.createCars(dto));
    }
//    @PostMapping("/electic-car/createCars")
//    public ResponseEntity<List<ElectricCar>> createElectricCars(@RequestBody @Valid List<ElectricCarCreateRequestDto> dtoList){
//        return ResponseEntity.ok(carService.createElectricCars(dtoList));
//    }
}
