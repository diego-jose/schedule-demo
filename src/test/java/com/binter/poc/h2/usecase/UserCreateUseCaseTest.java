package com.binter.poc.h2.usecase;

import com.binter.poc.h2.usecase.entity.User;
import com.binter.poc.h2.usecase.gateway.UserCreateGateway;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserCreateUseCaseTest {

    @Mock
    private UserCreateGateway gateway;


    private UserCreateUseCase useCase;

    @Before
    public void setUp(){
        useCase = new UserCreateUseCase(gateway);
    }

    @Test
    public void testUserCaseSaveSuccess(){

        User userToSave = User.builder().nome("Diego Jose").email("diegojs@ciandt.com").build();

        User created = User.builder().id(1L).nome("Diego Jose").email("diegojs@ciandt.com").build();


        when(gateway.save(any(User.class))).thenReturn(created);

        User newUser= useCase.save(userToSave);

        verify(gateway, times(1)).save(userToSave);

        Assert.assertThat(newUser, Matchers.equalTo(created));
    }

    @Test
    public void testUserCaseSaveReturNull(){

        User newUser= useCase.save(null);

        verify(gateway, times(1)).save(null);

        Assert.assertThat(newUser, Matchers.nullValue());
    }
}
