package com.binter.poc.h2.dataprovider.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UniqueDigitEntity {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String number;

    @NonNull
    private int ktimes;

    @NonNull
    private int result;

    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity user;


}
