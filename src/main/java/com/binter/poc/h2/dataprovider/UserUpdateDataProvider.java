package com.binter.poc.h2.dataprovider;

import com.binter.poc.h2.dataprovider.repository.UserRepository;
import com.binter.poc.h2.dataprovider.repository.entity.UserEntity;
import com.binter.poc.h2.usecase.entity.User;
import com.binter.poc.h2.usecase.gateway.UserUpdateGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.binter.poc.h2.dataprovider.mapper.UserDataProviderMapper.from;

@Component
public class UserUpdateDataProvider implements UserUpdateGateway {

    private UserRepository repository;

    @Autowired
    public UserUpdateDataProvider(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User update(User user) {
        UserEntity userEntity = from(user);
        return from(repository.save(userEntity));
    }
}
