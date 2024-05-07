package com.alperen.mapper;

import com.alperen.dto.request.CarCreateRequestDto;
import com.alperen.dto.request.ElectricCarCreateRequestDto;
import com.alperen.entity.ElectricCar;
import com.alperen.entity.HybridCar;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HybridCarMapper {

    HybridCarMapper INSTANCE = Mappers.getMapper(HybridCarMapper.class);

    List<HybridCar> fromCarCreateRequestToHybridCars(final List<CarCreateRequestDto> dtoList);
}
