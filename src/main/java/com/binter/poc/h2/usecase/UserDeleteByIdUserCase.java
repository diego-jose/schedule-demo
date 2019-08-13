package com.binter.poc.h2.usecase;

import com.binter.poc.h2.usecase.gateway.UserDeleteByIdGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDeleteByIdUserCase {

    private UserDeleteByIdGateway gateway;

    @Autowired
    public UserDeleteByIdUserCase(UserDeleteByIdGateway gateway) {
        this.gateway = gateway;
    }

    public String delete(Long id){
        return gateway.delete(id);
    }
}
