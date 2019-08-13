package com.binter.poc.h2.entrypoint;


import com.binter.poc.h2.usecase.UserUpdateUserCase;
import com.binter.poc.h2.usecase.entity.User;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user")
@Api
public class UserUpdateEndPoint {

    private UserUpdateUserCase useCase;

    @Autowired
    public UserUpdateEndPoint(UserUpdateUserCase useCase) {
        this.useCase = useCase;
    }

    @PutMapping(path="/{id}", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody User user){

        User update = useCase.update(user);

        return ResponseEntity.noContent().build();
    }
}
