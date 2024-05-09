package com.alperen.service;

import com.alperen.dto.request.CarCreateRequestDto;
import com.alperen.entity.ElectricCar;
import com.alperen.entity.ElectricEngine;
import com.alperen.entity.FuelCar;
import com.alperen.entity.HybridCar;
import com.alperen.mapper.FuelCarMapper;
import com.alperen.mapper.HybridCarMapper;
import com.alperen.repository.ElectricEngineRepository;
import com.alperen.repository.FuelCarRepository;
import com.alperen.utility.CarCodeGenerator;
import com.alperen.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuelCarService extends ServiceManager<FuelCar,Long> {
    private final FuelCarRepository fuelCarRepository;

    public FuelCarService(FuelCarRepository fuelCarRepository) {
        super(fuelCarRepository);
        this.fuelCarRepository = fuelCarRepository;

    }

    public List<FuelCar> createFuelCars(List<CarCreateRequestDto> dtoList) {
        List<FuelCar> fuelCarList = FuelCarMapper.INSTANCE.fromCarCreateRequestToFuelCars(dtoList);
        String batchNumber = CarCodeGenerator.generateBatchNumber();
        fuelCarList.forEach(car -> car.setCarCode(CarCodeGenerator.generateCarCode(batchNumber,car)));
        return (List<FuelCar>) saveAll(fuelCarList);
    }

    public Optional<FuelCar> findByCarCode(String carCode){
        return fuelCarRepository.findByCarCode(carCode);
    }
}

