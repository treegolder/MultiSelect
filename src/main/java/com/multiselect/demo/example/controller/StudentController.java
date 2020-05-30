package com.multiselect.demo.example.controller;

import com.multiselect.demo.example.component.RequestComponent;
import com.multiselect.demo.example.entity.Student;
import com.multiselect.demo.example.entity.Teacher;

import com.multiselect.demo.example.service.StudentService;
import com.multiselect.demo.example.service.TeacherService;
import com.multiselect.demo.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
@RestController
@RequestMapping("/api/")
public class StudentController {
    @Autowired
    private UserService us;
    @Autowired
    private TeacherService ts;
    @Autowired
    private StudentService ss;
    @Autowired
    private RequestComponent requestComponent;

    @PostMapping("choice/{tid}")
    public Map choice(@PathVariable int tid) {
        Student s;
        Teacher t = ts.getTeacher(tid);

        if(t.getStuNum() < t.getStuCap()) {
            s = ss.getStudent(requestComponent.getUid());
            s.setTeacher(ts.getTeacher(tid));
        }else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"人数已满");
        return Map.of("student",s);
    }

}
