package com.alperen.service;

import com.alperen.entity.CreditCardInfo;
import com.alperen.repository.CreditCardInfoRepository;
import com.alperen.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
public class CreditCardInfoService extends ServiceManager<CreditCardInfo, Long> {
    private final CreditCardInfoRepository creditCardInfoRepository;

    //TODO Kredi kartı bilgilerini bulup getiren bir
    // metot olmamalı ancak, olması ya da bilgi karşılaştırma durumunda decrypt edilip öyle karşılaştırılmalı.
    public CreditCardInfoService(CreditCardInfoRepository creditCardInfoRepository) {
        super(creditCardInfoRepository);
        this.creditCardInfoRepository = creditCardInfoRepository;
    }

    public Optional<CreditCardInfo> findByCreditCardNo(String creditCardNo) {
        return creditCardInfoRepository.findByCreditCardNo(creditCardNo);
    }

    public Boolean doesCreditCardInfoExists(CreditCardInfo creditCardInfo) {
        return creditCardInfoRepository.existsByOwnersNameAndOwnersSurnameAndCreditCardNoAndCreditCardExpirationDateAndCvc(
                creditCardInfo.getOwnersName(), creditCardInfo.getOwnersSurname(),
                creditCardInfo.getCreditCardNo(), creditCardInfo.getCreditCardExpirationDate(),
                creditCardInfo.getCvc());
    }
    public Optional<CreditCardInfo> findDuplicateCreditCardInfo(CreditCardInfo creditCardInfo) {
        return creditCardInfoRepository.findByOwnersNameAndOwnersSurnameAndCreditCardNoAndCreditCardExpirationDateAndCvc(
                creditCardInfo.getOwnersName(), creditCardInfo.getOwnersSurname(),
                creditCardInfo.getCreditCardNo(), creditCardInfo.getCreditCardExpirationDate(),
                creditCardInfo.getCvc());
    }
    public CreditCardInfo saveIfNotExists(CreditCardInfo creditCardInfo){
        if (!doesCreditCardInfoExists(creditCardInfo)) {
            save(creditCardInfo);
        } else {
            creditCardInfo = findDuplicateCreditCardInfo(creditCardInfo).get();
        }
        return creditCardInfo;
    }

    //Encryption
//    public CreditCardInfo createCreditCardInfo(CreditCardInfo creditCardInfo){
//
//        creditCardInfo.setCreditCardNo(Base64.getEncoder().encodeToString(creditCardInfo.getCreditCardNo().getBytes()));
//        creditCardInfo.setCvc(Base64.getEncoder().encodeToString(creditCardInfo.getCvc().getBytes()));
//        creditCardInfo.setCreditCardExpirationDate(Base64.getEncoder().encodeToString(creditCardInfo.getCreditCardExpirationDate().getBytes()));
//        return save(creditCardInfo);
//    }


}

