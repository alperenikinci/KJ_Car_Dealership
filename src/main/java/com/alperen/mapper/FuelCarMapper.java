package com.alperen.mapper;

import com.alperen.dto.request.CarCreateRequestDto;
import com.alperen.dto.request.ElectricCarCreateRequestDto;
import com.alperen.entity.ElectricCar;
import com.alperen.entity.FuelCar;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FuelCarMapper {

    FuelCarMapper INSTANCE = Mappers.getMapper(FuelCarMapper.class);


    List<FuelCar> fromCarCreateRequestToFuelCars(final List<CarCreateRequestDto> dtoList);
}
