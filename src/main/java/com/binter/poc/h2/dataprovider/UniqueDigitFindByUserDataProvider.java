package com.binter.poc.h2.dataprovider;

import com.binter.poc.h2.dataprovider.repository.UniqueDigitRepository;
import com.binter.poc.h2.usecase.entity.UniqueDigit;
import com.binter.poc.h2.usecase.gateway.UniqueDigitFindByUserGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.binter.poc.h2.dataprovider.mapper.UniqueDigitDataProviderMapper.toListCore;

@Component
public class UniqueDigitFindByUserDataProvider implements UniqueDigitFindByUserGateway {

    private UniqueDigitRepository repository;

    @Autowired
    public UniqueDigitFindByUserDataProvider(UniqueDigitRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UniqueDigit> findByIdUser(Long idUser) {
        
        List<UniqueDigit> uniqueDigits = toListCore(repository.findUniqueDigitByUserId(idUser));
        return uniqueDigits;
    }
}
