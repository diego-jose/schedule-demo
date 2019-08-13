package com.binter.poc.h2.dataprovider.repository;

import com.binter.poc.h2.dataprovider.repository.entity.UniqueDigitEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UniqueDigitRepository extends PagingAndSortingRepository<UniqueDigitEntity, Long> {

    @Query("select d from UniqueDigitEntity d left join fetch d.user u where u.id = :idUser")
    List<UniqueDigitEntity> findUniqueDigitByUserId(@Param("idUser") Long idUser);


}
