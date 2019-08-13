package com.binter.poc.h2.usecase;

import com.binter.poc.h2.usecase.entity.User;
import com.binter.poc.h2.usecase.gateway.UserFindAllGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserCaseFindAll {

    private UserFindAllGateway gateway;

    @Autowired
    public UserCaseFindAll(UserFindAllGateway gateway) {
        this.gateway = gateway;
    }

    public List<User> findAll() {
        return gateway.findAll();
    }
}
