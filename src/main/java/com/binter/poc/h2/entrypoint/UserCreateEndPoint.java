package com.binter.poc.h2.entrypoint;


import com.binter.poc.h2.usecase.UserCreateUseCase;
import com.binter.poc.h2.usecase.entity.User;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/user")
@Api
public class UserCreateEndPoint {

    private UserCreateUseCase useCase;

    @Autowired
    public UserCreateEndPoint(UserCreateUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping(consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> create(@RequestBody User user){

        User created = useCase.save(user);
        if (created == null) {
            return ResponseEntity.unprocessableEntity().build();
        }

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(user.getId()).toUri();
        ResponseEntity<User> response = ResponseEntity.created(uri).contentType(MediaType.APPLICATION_JSON_UTF8).body(created);

        return response;
    }
}
