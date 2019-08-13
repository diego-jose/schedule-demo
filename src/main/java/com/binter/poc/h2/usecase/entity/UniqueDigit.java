package com.binter.poc.h2.usecase.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UniqueDigit {

    private Long id;

    private String number;

    private int ktimes;

    private int result;

    private User user;
}
