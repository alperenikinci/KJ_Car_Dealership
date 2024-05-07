package com.alperen.mapper;

import com.alperen.dto.request.OrderRequestDto;
import com.alperen.entity.Address;
import com.alperen.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer fromOrderRequestToCustomer(final OrderRequestDto dto);
}
