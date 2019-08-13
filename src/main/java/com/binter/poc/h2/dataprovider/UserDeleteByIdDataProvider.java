package com.binter.poc.h2.dataprovider;

import com.binter.poc.h2.dataprovider.repository.UserRepository;
import com.binter.poc.h2.usecase.gateway.UserDeleteByIdGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDeleteByIdDataProvider implements UserDeleteByIdGateway {

    public static final String USUÁRIO_DELETADO_COM_SUCESSO = "Usuário deletado com Sucesso";

    private UserRepository repository;

    @Autowired
    public UserDeleteByIdDataProvider(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public String delete(Long id) {
        repository.deleteById(id);
        return USUÁRIO_DELETADO_COM_SUCESSO;
    }
}
