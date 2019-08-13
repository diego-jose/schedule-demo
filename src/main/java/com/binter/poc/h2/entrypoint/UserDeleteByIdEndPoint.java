package com.binter.poc.h2.entrypoint;


import com.binter.poc.h2.usecase.UserDeleteByIdUserCase;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user")
@Api
public class UserDeleteByIdEndPoint {

    private UserDeleteByIdUserCase userCase;

    @Autowired
    public UserDeleteByIdEndPoint(UserDeleteByIdUserCase userCase) {
        this.userCase = userCase;
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> delete(@PathVariable long id) {
        try{
            return new ResponseEntity(userCase.delete(id), HttpStatus.NO_CONTENT);
        }catch (EmptyResultDataAccessException e){
           return new ResponseEntity<>("Usuario não encontrado", HttpStatus.NOT_FOUND);
        }
    }
}
