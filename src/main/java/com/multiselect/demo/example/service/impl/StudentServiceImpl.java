package com.multiselect.demo.example.service.impl;

import com.multiselect.demo.example.entity.Student;
import com.multiselect.demo.example.repository.StudentRepository;
import com.multiselect.demo.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository sr;
    @Override
    public Student login(String sno) {
      Student student = sr.findById(sno).orElse(null);

      return student;
    }
}
