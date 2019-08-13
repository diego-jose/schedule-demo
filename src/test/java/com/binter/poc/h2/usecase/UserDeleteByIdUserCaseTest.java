package com.binter.poc.h2.usecase;

import com.binter.poc.h2.usecase.gateway.UserDeleteByIdGateway;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserDeleteByIdUserCaseTest {

    @Mock
    private UserDeleteByIdGateway gateway;

    private UserDeleteByIdUserCase userCase;

    @Before
    public void setUp(){
        userCase = new UserDeleteByIdUserCase(gateway);
    }


    @Test
    public void testDeleteSuccess(){
        when(gateway.delete(Mockito.anyLong())).thenReturn("OK");

        String delete = userCase.delete(1l);

        Mockito.verify(gateway, times(1)).delete(1l);

        assertThat(delete, Matchers.equalTo("OK"));

    }

}