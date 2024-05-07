package com.alperen.service;

import com.alperen.entity.ElectricEngine;
import com.alperen.entity.HybridEngine;
import com.alperen.repository.ElectricEngineRepository;
import com.alperen.repository.HybridEngineRepository;
import com.alperen.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class HybridEngineService extends ServiceManager<HybridEngine,Long> {
    private final HybridEngineRepository hybridEngineRepository;

    public HybridEngineService(HybridEngineRepository hybridEngineRepository) {
        super(hybridEngineRepository);
        this.hybridEngineRepository = hybridEngineRepository;

    }
}

