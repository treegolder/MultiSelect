package com.multiselect.demo.example.repository;

import com.multiselect.demo.example.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends BaseRepository<Teacher,String> {


}
