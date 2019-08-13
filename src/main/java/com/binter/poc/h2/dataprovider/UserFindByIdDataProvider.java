package com.binter.poc.h2.dataprovider;

import com.binter.poc.h2.dataprovider.mapper.UserDataProviderMapper;
import com.binter.poc.h2.dataprovider.repository.UserRepository;
import com.binter.poc.h2.dataprovider.repository.entity.UserEntity;
import com.binter.poc.h2.usecase.entity.User;
import com.binter.poc.h2.usecase.gateway.UserFindByIdGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserFindByIdDataProvider implements UserFindByIdGateway {

    private UserRepository repository;

    @Autowired
    public UserFindByIdDataProvider(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User find(Long id) {

        Optional<UserEntity> optUser = repository.findById(id);
        if (!optUser.isPresent()) {
            return null;
        }

        UserEntity userEntity = optUser.get();

        return UserDataProviderMapper.from(userEntity);
    }
}
