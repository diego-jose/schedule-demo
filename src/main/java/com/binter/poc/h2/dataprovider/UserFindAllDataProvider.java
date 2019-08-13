package com.binter.poc.h2.dataprovider;

import com.binter.poc.h2.dataprovider.mapper.UserDataProviderMapper;
import com.binter.poc.h2.dataprovider.repository.UserRepository;
import com.binter.poc.h2.dataprovider.repository.entity.UserEntity;
import com.binter.poc.h2.usecase.entity.User;
import com.binter.poc.h2.usecase.gateway.UserFindAllGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class UserFindAllDataProvider implements UserFindAllGateway {

    private UserRepository repository;

    @Autowired
    public UserFindAllDataProvider(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> findAll() {

        Iterable<UserEntity> entityIterable = repository.findAll();

        List<UserEntity> userList = new ArrayList(StreamSupport
                .stream(
                        Spliterators
                                .spliteratorUnknownSize(entityIterable.iterator(), Spliterator.ORDERED), false)
                .collect(
                        Collectors.toList()
                ));


        Page<UserEntity> userEntities = repository.findAll(Pageable.unpaged());

        return UserDataProviderMapper.from(userList);
    }
}
