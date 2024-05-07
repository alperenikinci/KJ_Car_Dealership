package com.alperen.mapper;

import com.alperen.dto.request.CarCreateRequestDto;
import com.alperen.dto.request.ElectricCarCreateRequestDto;

import com.alperen.entity.ElectricCar;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ElectricCarMapper {

    ElectricCarMapper INSTANCE = Mappers.getMapper(ElectricCarMapper.class);

    ElectricCar fromCreateRequestToElectricCar(final ElectricCarCreateRequestDto dto);
    List<ElectricCar> fromCreateRequestToElectricCars(final List<ElectricCarCreateRequestDto> dtoList);
    List<ElectricCar> fromCarCreateRequestToElectricCars(final List<CarCreateRequestDto> dtoList);
}
