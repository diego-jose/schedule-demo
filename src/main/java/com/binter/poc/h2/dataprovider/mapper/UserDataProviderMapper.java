package com.binter.poc.h2.dataprovider.mapper;

import com.binter.poc.h2.dataprovider.repository.entity.UserEntity;
import com.binter.poc.h2.usecase.entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.List;

import static com.binter.poc.h2.dataprovider.mapper.UniqueDigitDataProviderMapper.toListCore;
import static com.binter.poc.h2.dataprovider.mapper.UniqueDigitDataProviderMapper.toListEntity;
import static java.util.stream.Collectors.toList;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDataProviderMapper {

    public static UserEntity from(User user) {
        if(user == null){
            return null;
        }
        return UserEntity
                .builder()
                .id(user.getId())
                .nome(user.getNome())
                .email(user.getEmail())
                .uniqueDigitEntities(toListEntity(user.getUniqueDigits()))
                .build();
    }

    public static User from(UserEntity entity){
        if(entity == null){
            return null;
        }
        return User
                .builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .email(entity.getEmail())
                .uniqueDigits(toListCore(entity.getUniqueDigitEntities()))
                .build();
    }

    public static List<User> from(List<UserEntity> userEntities) {

       return userEntities.stream().map(UserDataProviderMapper::from).collect(toList());
    }
}
