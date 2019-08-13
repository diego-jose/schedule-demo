package com.binter.poc.h2.dataprovider.repository;

import com.binter.poc.h2.dataprovider.repository.entity.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {

}
