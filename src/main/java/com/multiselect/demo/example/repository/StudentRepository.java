package com.multiselect.demo.example.repository;

import com.multiselect.demo.example.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends BaseRepository<Student,String> {
}
