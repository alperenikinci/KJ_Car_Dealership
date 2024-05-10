package com.alperen.controller;

import com.alperen.dto.request.CarCreateRequestDto;

import com.alperen.entity.superclasses.Car;
import com.alperen.service.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.alperen.constant.RestApiUrls.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(CAR)
public class CarController {

    private final CarService carService;
    @PostMapping(CREATE)
    public ResponseEntity<List<Car>> createCars(@RequestBody @Valid  List<CarCreateRequestDto> dto){
        return ResponseEntity.ok(carService.createCars(dto));
    }
}
