package com.binter.poc.h2.usecase;

import org.springframework.stereotype.Component;

@Component
public class UniqueDigitUserCase {

    public Integer execute(String number, Integer ktimes){
        return  superDigit(number, ktimes);
    }


    private Integer superDigit(String number, Integer ktimes){
        number = number.chars().mapToLong(Character::getNumericValue).sum() * ktimes
                + "";
        return (number.length() > 1) ? superDigit(number, 1) :
                Character.getNumericValue(number.charAt(0));
    }
}
