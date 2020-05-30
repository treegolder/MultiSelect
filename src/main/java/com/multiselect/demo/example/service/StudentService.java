package com.multiselect.demo.example.service;

import com.multiselect.demo.example.entity.Direction;
import com.multiselect.demo.example.entity.SC;
import com.multiselect.demo.example.entity.Student;
import com.multiselect.demo.example.entity.Teacher;
import com.multiselect.demo.example.repository.DirectionRepository;
import com.multiselect.demo.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentService {
    @Autowired
    StudentRepository sr;
    @Autowired
    TeacherService ts;
    @Autowired
    DirectionRepository dr;

    public Student getStudent(int sid) {
        return sr.find(sid);
    }
    public Direction getDirection(int did) {
        return dr.findById(did).orElse(null);
    }


}
