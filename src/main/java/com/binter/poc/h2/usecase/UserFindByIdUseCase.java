package com.binter.poc.h2.usecase;

import com.binter.poc.h2.usecase.entity.User;
import com.binter.poc.h2.usecase.gateway.UserFindByIdGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserFindByIdUseCase {

    private UserFindByIdGateway gateway;

    @Autowired
    public UserFindByIdUseCase(UserFindByIdGateway gateway) {
        this.gateway = gateway;
    }

    public User find(Long id){

        return gateway.find(id);
    }
}
