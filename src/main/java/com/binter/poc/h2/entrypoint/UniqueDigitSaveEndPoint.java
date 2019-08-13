package com.binter.poc.h2.entrypoint;


import com.binter.poc.h2.usecase.UniqueDigitSaveCalculateUseCase;
import com.binter.poc.h2.usecase.entity.UniqueDigit;
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
@RequestMapping(value = "/api/unique-digit")
@Api
public class UniqueDigitSaveEndPoint {

    private UniqueDigitSaveCalculateUseCase uniqueDigitSaveCalculateUseCase;

    @Autowired
    public UniqueDigitSaveEndPoint(UniqueDigitSaveCalculateUseCase uniqueDigitSaveCalculateUseCase) {
        this.uniqueDigitSaveCalculateUseCase = uniqueDigitSaveCalculateUseCase;
    }

    @PostMapping(consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,
                        produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UniqueDigit> create(@RequestBody UniqueDigit uniqueDigit){

        UniqueDigit created = uniqueDigitSaveCalculateUseCase.save(uniqueDigit);

        if (created == null) {
            return ResponseEntity.unprocessableEntity().build();
        }

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(uniqueDigit.getId()).toUri();

        return  ResponseEntity.created(uri).contentType(MediaType.APPLICATION_JSON_UTF8).body(created);

    }
}
