package com.alperen.service;

import com.alperen.entity.ElectricCar;
import com.alperen.entity.FuelCar;
import com.alperen.repository.ElectricCarRepository;
import com.alperen.repository.FuelCarRepository;
import com.alperen.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class ElectricCarService extends ServiceManager<ElectricCar,Long> {
    private final ElectricCarRepository electricCarRepository;


    public ElectricCarService(ElectricCarRepository electricCarRepository) {
        super(electricCarRepository);
        this.electricCarRepository = electricCarRepository;

    }
}

