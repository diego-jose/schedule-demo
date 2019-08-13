package com.binter.poc.h2.usecase;

import com.binter.poc.h2.usecase.entity.User;
import com.binter.poc.h2.usecase.gateway.UserUpdateGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserUpdateUserCase {

    private UserUpdateGateway gateway;

    @Autowired
    public UserUpdateUserCase(UserUpdateGateway gateway) {
        this.gateway = gateway;
    }

    public User update(User user) {

        return gateway.update(user);
    }
}
