package com.binter.poc.h2.entrypoint;


import com.binter.poc.h2.usecase.UserFindByIdUseCase;
import com.binter.poc.h2.usecase.entity.User;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user")
@Api
public class UserFindByIdEndPoint {

    private UserFindByIdUseCase useCase;

    @Autowired
    public UserFindByIdEndPoint(UserFindByIdUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<User> find(@PathVariable("id") Long id){

        return new ResponseEntity<>(useCase.find(id), HttpStatus.OK);

    }
}
