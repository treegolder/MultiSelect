package com.multiselect.demo.example.service;

import com.multiselect.demo.example.entity.Student;
import com.multiselect.demo.example.entity.Teacher;
import com.multiselect.demo.example.entity.User;
import com.multiselect.demo.example.repository.StudentRepository;
import com.multiselect.demo.example.repository.TeacherRepository;
import com.multiselect.demo.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository ur;
    @Autowired
    TeacherRepository tr;
    @Autowired
    StudentRepository sr;

    public User getUser(int number) {
       return ur.find(number);
    }
    public Teacher addTeacher( Teacher teacher) {
       return tr.save(teacher);
    }
    public Teacher getTeacher(int tid) {
        return tr.find(tid);
    }
    public Student getStudent(int sid) {
        return sr.find(sid);
    }

}
