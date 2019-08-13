package com.binter.poc.h2.entrypoint;


import com.binter.poc.h2.usecase.UserCaseFindAll;
import com.binter.poc.h2.usecase.entity.User;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
@Api
public class UserFindAllEndPoint {

    private UserCaseFindAll useCase;

    @Autowired
    public UserFindAllEndPoint(UserCaseFindAll useCase) {
        this.useCase = useCase;
    }

    @GetMapping( produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<User>> findAll(){

        return new ResponseEntity<>(useCase.findAll(), HttpStatus.OK);
    }



}
