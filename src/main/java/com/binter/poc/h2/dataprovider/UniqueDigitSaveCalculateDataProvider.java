package com.binter.poc.h2.dataprovider;

import com.binter.poc.h2.dataprovider.repository.UniqueDigitRepository;
import com.binter.poc.h2.dataprovider.repository.entity.UniqueDigitEntity;
import com.binter.poc.h2.usecase.entity.UniqueDigit;
import com.binter.poc.h2.usecase.gateway.UniqueDigitSaveCalculateGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.binter.poc.h2.dataprovider.mapper.UniqueDigitDataProviderMapper.from;


@Component
public class UniqueDigitSaveCalculateDataProvider implements UniqueDigitSaveCalculateGateway {

    private UniqueDigitRepository repository;

    @Autowired
    public UniqueDigitSaveCalculateDataProvider(UniqueDigitRepository repository) {

        this.repository = repository;
    }

    @Override
    public UniqueDigit save(UniqueDigit uniqueDigit) {

        UniqueDigitEntity uniqueDigitEntity = from(uniqueDigit);

       return from(repository.save(uniqueDigitEntity));

    }
}
