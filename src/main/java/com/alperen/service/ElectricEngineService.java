package com.alperen.service;

import com.alperen.dto.request.OrderRequestDto;
import com.alperen.entity.*;
import com.alperen.mapper.AddressMapper;
import com.alperen.mapper.CustomerMapper;
import com.alperen.mapper.OrderMapper;
import com.alperen.repository.ElectricEngineRepository;
import com.alperen.repository.OrderRepository;
import com.alperen.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class ElectricEngineService extends ServiceManager<ElectricEngine,Long> {
    private final ElectricEngineRepository electricEngineRepository;


    public ElectricEngineService(ElectricEngineRepository electricEngineRepository) {
        super(electricEngineRepository);
        this.electricEngineRepository = electricEngineRepository;

    }
}

