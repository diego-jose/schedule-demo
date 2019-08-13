package com.binter.poc.h2.usecase.gateway;

import com.binter.poc.h2.usecase.entity.UniqueDigit;

import java.util.List;

public interface UniqueDigitFindByUserGateway {

    List<UniqueDigit> findByIdUser(Long idUser);
}
