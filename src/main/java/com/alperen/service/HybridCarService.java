package com.alperen.service;

import com.alperen.dto.request.CarCreateRequestDto;
import com.alperen.entity.ElectricCar;
import com.alperen.entity.FuelCar;
import com.alperen.entity.HybridCar;
import com.alperen.mapper.ElectricCarMapper;
import com.alperen.mapper.HybridCarMapper;
import com.alperen.repository.FuelCarRepository;
import com.alperen.repository.HybridCarRepository;
import com.alperen.utility.CarCodeGenerator;
import com.alperen.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HybridCarService extends ServiceManager<HybridCar,Long> {
    private final HybridCarRepository hybridCarRepository;

    public HybridCarService(HybridCarRepository hybridCarRepository) {
        super(hybridCarRepository);
        this.hybridCarRepository = hybridCarRepository;
    }

    public List<HybridCar> createHybridCars(List<CarCreateRequestDto> dtoList) {
        List<HybridCar> hybridCarList = HybridCarMapper.INSTANCE.fromCarCreateRequestToHybridCars(dtoList);
        String batchNumber = CarCodeGenerator.generateBatchNumber();
        hybridCarList.forEach(car -> car.setCarCode(CarCodeGenerator.generateCarCode(batchNumber,car)));
        return (List<HybridCar>) saveAll(hybridCarList);
    }
}

