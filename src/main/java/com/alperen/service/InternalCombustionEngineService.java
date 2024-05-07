package com.alperen.service;

import com.alperen.entity.ElectricEngine;
import com.alperen.entity.InternalCombustionEngine;
import com.alperen.repository.ElectricEngineRepository;
import com.alperen.repository.InternalCombustionEngineRepository;
import com.alperen.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class InternalCombustionEngineService extends ServiceManager<InternalCombustionEngine,Long> {
    private final InternalCombustionEngineRepository internalCombustionEngineRepository;


    public InternalCombustionEngineService(InternalCombustionEngineRepository internalCombustionEngineRepository) {
        super(internalCombustionEngineRepository);
        this.internalCombustionEngineRepository = internalCombustionEngineRepository;

    }
}

