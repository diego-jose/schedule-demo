package com.binter.poc.h2.usecase;

import com.binter.poc.h2.usecase.entity.User;
import com.binter.poc.h2.usecase.gateway.UserCreateGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserCreateUseCase {

    private UserCreateGateway gateway;

    @Autowired
    public UserCreateUseCase(UserCreateGateway gateway) {
        this.gateway = gateway;
    }

    public User save(User user) {

        return gateway.save(user);
    }
}
