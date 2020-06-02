package com.multiselect.demo.example.repository;

import com.multiselect.demo.example.entity.Teacher;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends BaseRepository<Teacher,Integer> {

/*    @Modifying
    @Query("update Teacher t set t.sum=:newsum where t.id=:id")
    int updateSum(@Param("id") String id, @Param("newsum") int sum);*/
    @Query("from Teacher t where t.id=:tid")
    Teacher find(@Param("tid") int tid);
}
