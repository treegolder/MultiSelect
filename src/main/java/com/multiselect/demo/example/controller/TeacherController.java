package com.multiselect.demo.example.controller;

import com.multiselect.demo.example.component.RequestComponent;
import com.multiselect.demo.example.entity.Course;
import com.multiselect.demo.example.entity.Direction;
import com.multiselect.demo.example.entity.Student;
import com.multiselect.demo.example.entity.Teacher;
import com.multiselect.demo.example.service.StudentService;
import com.multiselect.demo.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/api/teacher/")
public class TeacherController {
    @Autowired
    TeacherService ts;
    @Autowired
    RequestComponent rc;
    @Autowired
    StudentService ss;
    @PostMapping("adddirection")
    public Map postDirection(@RequestBody Direction direction) {

        if(direction.getName() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"方向不能为空");
        Teacher t = ts.getTeacher(rc.getUid());
        direction.setTeacher(t);
        direction = ts.postDirection(direction);
       return Map.of("direction",direction);
    }
    @PostMapping("directions/{did}/addcourse")
    public Map postCourse(@PathVariable int did, @RequestBody Course course) {
        Direction direction = ts.getDirection(did);
        if (direction != null) {
            for(Course c : direction.getCourses() )
                if(c.getName().equals(course.getName()))
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"已添加过该课程");
            course.setDirection(direction);
            course.setTeacher(ts.getTeacher(rc.getUid()));
            ts.postCourse(course);
            return Map.of("course",course);
        }
        else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"方向不存在");
    }
    @GetMapping("listdirections")
    public Map listDirections() {
        return Map.of("listDirections", ts.getDirections(rc.getUid()));
    }

    @PostMapping("students/{sid}/addstudent")
    public Map postStudent(@PathVariable int sid) {
       return Map.of("student",ts.addStudent(sid));
    }
    @GetMapping("directions/{did}/liststudents")
    public Map listStudent(@PathVariable int did) {
       return Map.of("liststudent", ts.listStudent(did));
    }
    @PostMapping("deletestudent/students/{sid}")
    public Map deleteStudent(@PathVariable int sid) {
        return Map.of("student", ts.deleteStudent(sid));
    }
    @GetMapping("liststudent")
    public Map listStudent() {
        return Map.of("listStudents",ts.getTeacher(rc.getUid()).getStudents());
    }

    @PostMapping("setstucap")
    public int setSetCap(@RequestBody Integer stuCap) {
       return ts.setStuCap(stuCap);
    }
    @GetMapping("getstucap")
    public Map getStuCap() {
        return Map.of("stuCap", ts.getTeacher(rc.getUid()).getStuCap());
    }
    @GetMapping("getstunum")
    public Map getStuNum() {
        return Map.of("stuNum", ts.getTeacher(rc.getUid()).getStuNum());
    }


}
