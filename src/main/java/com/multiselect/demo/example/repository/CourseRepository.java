package com.multiselect.demo.example.repository;

import com.multiselect.demo.example.entity.Course;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends BaseRepository<Course,Integer> {

   Course findByName(String name);


}
