package com.binter.poc.h2.usecase.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;

    private String nome;

    private String email;

    private List<UniqueDigit> uniqueDigits;
}
