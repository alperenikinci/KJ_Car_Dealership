package com.alperen.mapper;

import com.alperen.dto.request.OrderRequestDto;
import com.alperen.entity.Address;
import com.alperen.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    Address fromOrderRequestToAddress(final OrderRequestDto dto);
}
