package com.binter.poc.h2.usecase.gateway;

import com.binter.poc.h2.usecase.entity.User;

public interface UserFindByIdGateway {

    User find(Long id);
}
