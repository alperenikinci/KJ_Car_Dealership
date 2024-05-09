package com.alperen.service;

import com.alperen.entity.CreditCardInfo;
import com.alperen.entity.PaymentInfo;
import com.alperen.repository.CreditCardInfoRepository;
import com.alperen.repository.PaymentInfoRepository;
import com.alperen.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class PaymentInfoService extends ServiceManager<PaymentInfo,Long> {
    private final PaymentInfoRepository paymentInfoRepository;


    public PaymentInfoService(PaymentInfoRepository paymentInfoRepository) {
        super(paymentInfoRepository);
        this.paymentInfoRepository = paymentInfoRepository;
    }


}

