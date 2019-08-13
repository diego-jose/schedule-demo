package com.binter.poc.h2.dataprovider;

import com.binter.poc.h2.dataprovider.repository.UserRepository;
import com.binter.poc.h2.dataprovider.repository.entity.UserEntity;
import com.binter.poc.h2.usecase.entity.User;
import com.binter.poc.h2.usecase.gateway.UserCreateGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.binter.poc.h2.dataprovider.mapper.UserDataProviderMapper.from;

@Component
public class UserCreateDataProvider implements UserCreateGateway {

    private UserRepository repository;

    @Autowired
    public UserCreateDataProvider(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        if(user == null) {
            return null;
        }
        UserEntity userEntity = from(user);

        return from(repository.save(userEntity));
    }
}
