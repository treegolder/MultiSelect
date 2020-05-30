package com.multiselect.demo.example.service;

import com.multiselect.demo.example.entity.Course;
import com.multiselect.demo.example.entity.Direction;
import com.multiselect.demo.example.entity.Teacher;
import com.multiselect.demo.example.repository.CourseRepository;
import com.multiselect.demo.example.repository.DirectionRepository;
import com.multiselect.demo.example.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeacherService {
    @Autowired
    TeacherRepository tr;
    @Autowired
    DirectionRepository dr;
    @Autowired
    CourseRepository cr;

    public Teacher getTeacher(int tid) {
        return tr.find(tid);
    }
    public List<Teacher> listTeacher() {
        return tr.findAll();
    }
    public void setWeight(int did,int cid,double weight) {
        Direction direction = dr.findById(did).orElse(null);
        Course course = cr.findById(cid).orElse(null);
        course.setWeight(weight);
        course.setDirection(direction);
    }
    public void setThreshold(int tid, int threshold,int did) {
        Direction direction = dr.findById(did).orElse(null);
        Teacher teacher = getTeacher(tid);
        direction.setTeacher(teacher);
        direction.setThreshold(threshold);
    }

}
