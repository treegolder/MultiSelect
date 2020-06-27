package com.multiselect.demo.example.controller;

import com.multiselect.demo.example.component.RequestComponent;
import com.multiselect.demo.example.entity.Direction;
import com.multiselect.demo.example.entity.Student;
import com.multiselect.demo.example.entity.Teacher;

import com.multiselect.demo.example.service.StudentService;
import com.multiselect.demo.example.service.TeacherService;
import com.multiselect.demo.example.service.UserService;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
@RestController
@RequestMapping("/api/student/")
public class StudentController {
    @Autowired
    private UserService us;
    @Autowired
    private TeacherService ts;
    @Autowired
    private StudentService ss;
    @Autowired
    private RequestComponent requestComponent;

    @GetMapping("listTeacher")
    public Map listTeachers() {
       return Map.of("teacherList",ss.teacherList()) ;
    }
    @GetMapping("teachers/{tid}/directions")
    public Map ListTeacherDirections(@PathVariable int tid) {
       return Map.of("teacherDirections", ts.getTeacher(tid).getDirections());
    }

    @PostMapping("addDirection")
    public Map selectDirection(@RequestBody Direction direction) {

        Student student = ss.getStudent(requestComponent.getUid());
        if(student.getDirection() == null)
            student.setDirection(direction.getName());
        else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"方向已选");

        ss.saveStudent(student);
       return Map.of("direction",direction);
    }
    @PostMapping("addTeacher")
    public Map selectTeacher(@RequestBody Teacher teacher) {
        Student s;

        if(teacher.getStuNum() < teacher.getStuCap()) {
            s = ss.getStudent(requestComponent.getUid());
            s.setTeacher(teacher);
        }else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"人数已满");
        if (s.getDirection() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"请先选择方向");

        ss.saveStudent(s);
        return Map.of("teacher",teacher);
    }
}
