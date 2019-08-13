package com.binter.poc.h2.dataprovider;

import com.binter.poc.h2.dataprovider.repository.UserRepository;
import com.binter.poc.h2.dataprovider.repository.entity.UserEntity;
import com.binter.poc.h2.usecase.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.binter.poc.h2.dataprovider.mapper.UserDataProviderMapper.from;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserCreateDataProviderTest {

    @Mock
    private UserRepository repository;

    private UserCreateDataProvider dataProvider;


    @Before
    public void setUp() {

        dataProvider = new UserCreateDataProvider(repository);
    }

    @Test
    public void testSaveUserShouldReturnSuccess() {

        UserEntity userFakeEntity = UserEntity
                .builder()
                .nome("Diego Jose")
                .email("diegojs@ciandt.com")
                .build();

        User user = from(userFakeEntity);

        when(repository.save(any(UserEntity.class))).thenReturn(userFakeEntity);

        User newUser = dataProvider.save(user);

        assertThat(newUser).isEqualTo(user);
    }


    @Test
    public void testSaveUserShouldReturnNull() {

        UserEntity userFakeEntity = null;

        User user = from(userFakeEntity);

        User newUser = dataProvider.save(user);

        assertThat(newUser).isEqualTo(user);
    }
}