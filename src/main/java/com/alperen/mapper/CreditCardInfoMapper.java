package com.alperen.mapper;

import com.alperen.dto.request.OrderRequestDto;
import com.alperen.dto.request.PaymentRequestDto;
import com.alperen.entity.CreditCardInfo;
import com.alperen.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreditCardInfoMapper {

    CreditCardInfoMapper INSTANCE = Mappers.getMapper(CreditCardInfoMapper.class);

    CreditCardInfo fromOrderRequestToCreditCardInfo(final OrderRequestDto dto);
    CreditCardInfo fromPaymentRequestToCreditCardInfo(final PaymentRequestDto dto);
}
