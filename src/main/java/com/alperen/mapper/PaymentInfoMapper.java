package com.alperen.mapper;

import com.alperen.dto.request.OrderRequestDto;
import com.alperen.entity.CreditCardInfo;
import com.alperen.entity.PaymentInfo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PaymentInfoMapper {

    PaymentInfoMapper INSTANCE = Mappers.getMapper(PaymentInfoMapper.class);

    PaymentInfo fromOrderRequestToPaymentInfo(final OrderRequestDto dto);
}
