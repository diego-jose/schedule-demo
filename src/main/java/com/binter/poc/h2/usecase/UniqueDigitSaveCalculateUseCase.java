package com.binter.poc.h2.usecase;

import com.binter.poc.h2.usecase.entity.UniqueDigit;
import com.binter.poc.h2.usecase.gateway.UniqueDigitSaveCalculateGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueDigitSaveCalculateUseCase {

    private UniqueDigitSaveCalculateGateway gateway;

    private UniqueDigitUserCase uniqueDigitUserCase;

    @Autowired
    public UniqueDigitSaveCalculateUseCase(UniqueDigitSaveCalculateGateway gateway, UniqueDigitUserCase uniqueDigitUserCase) {
        this.gateway = gateway;
        this.uniqueDigitUserCase = uniqueDigitUserCase;
    }


    public UniqueDigit save(UniqueDigit uniqueDigit){
        Integer superDigit = uniqueDigitUserCase.execute(uniqueDigit.getNumber(), uniqueDigit.getKtimes());

        //set result uniqueDigit
        uniqueDigit.setResult(superDigit);

        return  gateway.save(uniqueDigit);
    }
}
