package com.binter.poc.h2.usecase;

import com.binter.poc.h2.usecase.entity.UniqueDigit;
import com.binter.poc.h2.usecase.gateway.UniqueDigitFindByUserGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UniqueDigitFindByUserUserCase {

    private UniqueDigitFindByUserGateway gateway;

    @Autowired
    public UniqueDigitFindByUserUserCase(UniqueDigitFindByUserGateway gateway) {
        this.gateway = gateway;
    }

    public List<UniqueDigit> findByIdUser(Long idUser) {
        return gateway.findByIdUser(idUser);
    }
}
