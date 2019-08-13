package com.binter.poc.h2.dataprovider.mapper;

import com.binter.poc.h2.dataprovider.repository.entity.UniqueDigitEntity;
import com.binter.poc.h2.usecase.entity.UniqueDigit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class UniqueDigitDataProviderMapperTest {

    @Test
    public void testConvertEntityToCoreEntity(){

        UniqueDigitEntity entity = UniqueDigitEntity.builder()
                .id(1l)
                .number("9875")
                .ktimes(3)
                .result(8)
                .build();

        UniqueDigit digit = UniqueDigitDataProviderMapper.from(entity);

        assertThat(digit.getId()).isEqualTo(entity.getId());
        assertThat(digit.getNumber()).isEqualTo(entity.getNumber());
        assertThat(digit.getKtimes()).isEqualTo(entity.getKtimes());
        assertThat(digit.getResult()).isEqualTo(entity.getResult());
    }


    @Test
    public void testConvertNullEntityToNullCoreEntity(){

        UniqueDigitEntity entity = null;

        UniqueDigit digit = UniqueDigitDataProviderMapper.from(entity);

        assertThat(digit).isNull();
    }

    @Test
    public void testConvertCoreEntityToEntity(){

        UniqueDigit uniqueDigit = UniqueDigit.builder()
                .id(1l)
                .number("9875")
                .ktimes(3)
                .result(8)
                .build();

        UniqueDigitEntity digit = UniqueDigitDataProviderMapper.from(uniqueDigit);

        assertThat(digit.getId()).isEqualTo(uniqueDigit.getId());
        assertThat(digit.getNumber()).isEqualTo(uniqueDigit.getNumber());
        assertThat(digit.getKtimes()).isEqualTo(uniqueDigit.getKtimes());
        assertThat(digit.getResult()).isEqualTo(uniqueDigit.getResult());
    }

    @Test
    public void testConvertNullCoreEntityToNullEntity(){

        UniqueDigit uniqueDigit = null;

        UniqueDigitEntity digit = UniqueDigitDataProviderMapper.from(uniqueDigit);

        assertThat(digit).isNull();
    }

}