package com.binter.poc.h2.usecase.gateway;

import com.binter.poc.h2.usecase.entity.User;

import java.util.List;

public interface UserFindAllGateway {

    List<User> findAll();
}
