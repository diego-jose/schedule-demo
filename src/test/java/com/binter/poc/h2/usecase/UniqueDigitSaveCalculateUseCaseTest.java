package com.binter.poc.h2.usecase;


import com.binter.poc.h2.usecase.entity.UniqueDigit;
import com.binter.poc.h2.usecase.gateway.UniqueDigitSaveCalculateGateway;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UniqueDigitSaveCalculateUseCaseTest {

    @Mock
    private UniqueDigitSaveCalculateGateway gateway;

    @Mock
    private UniqueDigitUserCase uniqueDigitUserCase;

    private UniqueDigitSaveCalculateUseCase uniqueDigitSaveCalculateUseCase;

    @Before
    public void setUp(){
        uniqueDigitSaveCalculateUseCase = new UniqueDigitSaveCalculateUseCase(gateway, uniqueDigitUserCase);
    }


    @Test
    public void testUniqueDigitSaveSuccess(){
        Integer result = 5;
        UniqueDigit unique = UniqueDigit.builder().result(result).ktimes(3).number("123").build();

        Mockito.when(uniqueDigitUserCase.execute(Mockito.anyString(), Mockito.anyInt())).thenReturn(result);
        Mockito.when(gateway.save(Mockito.any(UniqueDigit.class))).thenReturn(unique);

        UniqueDigit digit = uniqueDigitSaveCalculateUseCase.save(unique);

        Mockito.verify(uniqueDigitUserCase, Mockito.times(1)).execute(unique.getNumber(), unique.getKtimes());

        Mockito.verify(gateway, Mockito.times(1)).save(unique);

        Assert.assertThat(digit, Matchers.equalTo(unique));


    }

}