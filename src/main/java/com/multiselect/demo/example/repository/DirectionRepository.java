package com.multiselect.demo.example.repository;

import com.multiselect.demo.example.entity.Direction;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectionRepository extends BaseRepository<Direction,Integer> {
 /*   @Modifying
    @Query("update Direction dr set dr.threshold=:threshold where dr.id=:id")
    int updateThreshold(@Param("threshold") double threshold, @Param("id") int id );*/
     Direction findByName(String name);
}
