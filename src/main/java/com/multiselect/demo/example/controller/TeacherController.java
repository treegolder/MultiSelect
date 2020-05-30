package com.multiselect.demo.example.controller;

import com.multiselect.demo.example.entity.Teacher;
import com.multiselect.demo.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class TeacherController {
    @Autowired
    TeacherService ts;
    public Map listStudents(int tid) {
        Teacher t = ts.getTeacher(tid);
       return Map.of("students",t.getStudents());
    }

}
