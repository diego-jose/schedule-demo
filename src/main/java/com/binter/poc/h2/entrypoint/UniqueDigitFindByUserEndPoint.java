package com.binter.poc.h2.entrypoint;

import com.binter.poc.h2.usecase.UniqueDigitFindByUserUserCase;
import com.binter.poc.h2.usecase.entity.UniqueDigit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/unique-digit")
@Api
public class UniqueDigitFindByUserEndPoint {

    private UniqueDigitFindByUserUserCase userCase;

    @Autowired
    public UniqueDigitFindByUserEndPoint(UniqueDigitFindByUserUserCase userCase) {
        this.userCase = userCase;
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Get the list of Unique digits by User available", notes = "This service will provide a list of skus available to POCS")
    public ResponseEntity<List<UniqueDigit>> find(@PathVariable("id") Long idUser){
        List<UniqueDigit> uniqueDigits = userCase.findByIdUser(idUser);
        return new ResponseEntity<>(uniqueDigits, HttpStatus.OK);
    }

}
