package com.alperen.service;

import com.alperen.entity.ElectricCar;
import com.alperen.entity.superclasses.Engine;
import com.alperen.repository.ElectricCarRepository;
import com.alperen.utility.ServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EngineService  {

    private final ElectricEngineService electricEngineService;
    private final InternalCombustionEngineService internalCombustionEngineService;
    private final HybridEngineService hybridEngineService;

}

