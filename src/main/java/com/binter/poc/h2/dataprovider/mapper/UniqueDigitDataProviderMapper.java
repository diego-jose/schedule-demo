package com.binter.poc.h2.dataprovider.mapper;

import com.binter.poc.h2.dataprovider.repository.entity.UniqueDigitEntity;
import com.binter.poc.h2.usecase.entity.UniqueDigit;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UniqueDigitDataProviderMapper {

    public static UniqueDigitEntity from(UniqueDigit uniqueDigit){
        if(uniqueDigit == null){
            return null;
        }
        return UniqueDigitEntity
                    .builder()
                    .id(uniqueDigit.getId())
                    .number(uniqueDigit.getNumber())
                    .ktimes(uniqueDigit.getKtimes())
                    .result(uniqueDigit.getResult())
                    .user(UserDataProviderMapper.from(uniqueDigit.getUser()))
                    .build();
    }

    public static UniqueDigit from(UniqueDigitEntity uniqueDigitEntity){

        if(uniqueDigitEntity == null){
            return null;
        }
        return UniqueDigit
                .builder()
                .id(uniqueDigitEntity.getId())
                .number(uniqueDigitEntity.getNumber())
                .ktimes(uniqueDigitEntity.getKtimes())
                .result(uniqueDigitEntity.getResult())
                .user(UserDataProviderMapper.from(uniqueDigitEntity.getUser()))
                .build();
    }

    public static List<UniqueDigitEntity> toListEntity (List<UniqueDigit> uniqueDigits) {
        if(CollectionUtils.isEmpty(uniqueDigits)){
            return Collections.emptyList();
        }
      return  uniqueDigits.stream().map(UniqueDigitDataProviderMapper::from).collect(toList());
    }

    public static List<UniqueDigit> toListCore(List<UniqueDigitEntity> uniqueDigitEntities) {
        if(CollectionUtils.isEmpty(uniqueDigitEntities)){
            return Collections.emptyList();
        }
        return  uniqueDigitEntities.stream().map(UniqueDigitDataProviderMapper::from).collect(toList());
    }
}
