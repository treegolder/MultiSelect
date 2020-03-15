package com.multiselect.demo.example.repository;

import com.multiselect.demo.example.entity.DC;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DCRepository extends BaseRepository<DC,String> {

    @Modifying
    @Query("update DC dc set dc.threshold=:threshold where dc.id=:id")
    int updateThreshold(@Param("threshold") double threshold, @Param("id") int id );
}
