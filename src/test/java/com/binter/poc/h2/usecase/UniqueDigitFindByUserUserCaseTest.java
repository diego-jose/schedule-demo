package com.binter.poc.h2.usecase;

import com.binter.poc.h2.usecase.entity.UniqueDigit;
import com.binter.poc.h2.usecase.gateway.UniqueDigitFindByUserGateway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UniqueDigitFindByUserUserCaseTest {

    @Mock
    private UniqueDigitFindByUserGateway gateway;

    private UniqueDigitFindByUserUserCase userUserCase;

    @Before
    public void setUp(){
        userUserCase = new UniqueDigitFindByUserUserCase(gateway);
    }

    @Test
    public void testFindSuccess(){
       List<UniqueDigit>  uniqueDigit = Arrays.asList(UniqueDigit
                                                        .builder()
                                                        .id(1l)
                                                        .id(1l)
                                                        .number("444")
                                                        .ktimes(3)
                                                        .result(8)
                                                        .build());
        when(gateway.findByIdUser(Mockito.anyLong())).thenReturn(uniqueDigit);

        List<UniqueDigit> digits = userUserCase.findByIdUser(1l);

        verify(gateway, times(1)).findByIdUser(1l);

        assertFalse(digits.isEmpty());
    }

    @Test
    public void testFindReturnEmptyList(){
        when(gateway.findByIdUser(Mockito.anyLong())).thenReturn(emptyList());

        List<UniqueDigit> digits = userUserCase.findByIdUser(1l);

        verify(gateway, times(1)).findByIdUser(1l);

        assertTrue(digits.isEmpty());
    }
}