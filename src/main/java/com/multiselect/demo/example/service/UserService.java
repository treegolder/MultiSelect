package com.multiselect.demo.example.service;

import com.multiselect.demo.example.entity.*;
import com.multiselect.demo.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository ur;
    @Autowired
    TeacherRepository tr;
    @Autowired
    StudentRepository sr;
    @Autowired
    SCRepository scr;
    @Autowired
    CourseRepository cr;
    @Autowired
    private PasswordEncoder encoder;

    public User getUser(int number) {
       return ur.find(number);
    }
    public Teacher addTeacher( Teacher teacher) {
       return tr.save(teacher);
    }
    public Student addStudent(Student student) {
        return sr.save(student);
    }
    public Teacher getTeacher(int tid) {
        return tr.find(tid);
    }
    public Student getStudent(int sid) {
        return sr.find(sid);
    }
    public List<Student> listStudents() {
        return sr.findAll();
    }
    public void importUser(List<User> userList) {
        for(User u : userList) {
            u.setPassword(encoder.encode(String.valueOf(u.getNumber())));
            u.setRole(User.Role.STUDENT);
            Student s = new Student();
            s.setUser(u);
            addStudent(s);
        }
    }
    public void importSC(List<SC> scList) {
        for(SC sc :scList) {
            Student stu = sr.findByNumber(sc.getNumber());
            sc.setStudent(stu);
            scr.save(sc);
        }
    }

}
