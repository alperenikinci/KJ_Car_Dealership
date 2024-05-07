package com.alperen.service;

import com.alperen.entity.ElectricEngine;
import com.alperen.entity.FuelCar;
import com.alperen.repository.ElectricEngineRepository;
import com.alperen.repository.FuelCarRepository;
import com.alperen.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class FuelCarService extends ServiceManager<FuelCar,Long> {
    private final FuelCarRepository fuelCarRepository;


    public FuelCarService(FuelCarRepository fuelCarRepository) {
        super(fuelCarRepository);
        this.fuelCarRepository = fuelCarRepository;

    }
}

