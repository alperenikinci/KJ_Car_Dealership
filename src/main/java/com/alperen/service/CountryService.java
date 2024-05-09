package com.alperen.service;

import com.alperen.dto.request.CarCreateRequestDto;
import com.alperen.dto.request.ElectricCarCreateRequestDto;
import com.alperen.entity.Country;
import com.alperen.entity.ElectricCar;
import com.alperen.mapper.ElectricCarMapper;
import com.alperen.repository.CountryRepository;
import com.alperen.repository.ElectricCarRepository;
import com.alperen.utility.CarCodeGenerator;
import com.alperen.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService extends ServiceManager<Country,Long> {
    private final CountryRepository countryRepository;


    public CountryService(CountryRepository countryRepository) {
        super(countryRepository);
        this.countryRepository = countryRepository;
    }


}

