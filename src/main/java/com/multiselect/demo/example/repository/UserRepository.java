package com.multiselect.demo.example.repository;

import com.multiselect.demo.example.entity.User;
import com.multiselect.demo.example.repository.impl.BaseRepositoryImpl;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public interface UserRepository extends BaseRepository<User,Integer> {

    @Query("from User u where u.number=:number ")
    User find(@Param("number") int number);

}
