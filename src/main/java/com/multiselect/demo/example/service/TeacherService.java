package com.multiselect.demo.example.service;

import com.multiselect.demo.example.component.RequestComponent;
import com.multiselect.demo.example.entity.*;
import com.multiselect.demo.example.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
@Slf4j
@Transactional
public class TeacherService {
    @Autowired
    TeacherRepository tr;
    @Autowired
    DirectionRepository dr;
    @Autowired
    CourseRepository cr;
    @Autowired
    RequestComponent rc;
    @Autowired
    StudentRepository sr;
    @Autowired
    SCRepository scr;
    @Autowired
    UserService us;

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
    public List<Direction> getDirections(int tid) {
        Teacher t = getTeacher(rc.getUid());
        return t.getDirections();
    }
    public Direction getDirection(int did) {
        Teacher t = getTeacher(rc.getUid());
        List<Direction> listDirections = t.getDirections();
        for(Direction d : listDirections) {
            if(d == dr.findById(did).orElse(null))
                return d;
        }
        return null;
    }
    public Direction postDirection(Direction direction) {
        if(dr.findByName(direction.getName()) == null)
            return dr.save(direction);
        else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"此方向已经存在");
    }
    public Course postCourse(Course course) {

            return cr.save(course);
    }
    public Student addStudent(int sid) {
        Student student = sr.find(sid);
        Teacher t = getTeacher(rc.getUid());
        for (Student s : t.getStudents())
            if (s == student)
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"此学生已入选");
        student.setTeacher(t);
        if (t.getStuNum() < t.getStuCap())
            t.setStuNum(t.getStuNum() + 1);
        else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "可选人数已达上限");
        return student;
    }

    /*
        将每一个方向，为所有学生根据不同的权重排序（降序）
     */
    public List<Map.Entry<Integer, Double>> listStudent(int did) {

        Direction direction = getDirection(did);
        HashMap<Course,Double> courseMap = new HashMap<>();
        HashMap<Integer,Double> studentMap = new HashMap<>();
        for (Course c : direction.getCourses())
            if(c.getDirection() == direction)
                courseMap.put(c,c.getWeight());

        Teacher t = getTeacher(rc.getUid());
        for (Student s : us.listStudents()) {
            double sum = 0;
            for (SC sc : s.getSc()) {
                Course course = cr.findByName(sc.getCourseName());
                if(courseMap.containsKey(course)) {
                    Double aDouble = courseMap.get(course);
                    sum += scr.findScoreByCourseName(sc.getCourseName(), s.getId())*aDouble;
                }
                studentMap.put(s.getUser().getNumber(),sum);
            }
        }

        List<Map.Entry<Integer, Double>> list = new ArrayList<>(studentMap.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Integer,Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                //降序
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for (Map.Entry s : list) {
            log.debug("{}", s.getKey());
        }
        return list;
    }
    public Student getStudentByNumber(int number) {
        return sr.findByNumber(number);
    }
    public Integer setStuCap(Integer stuCap) {
        Teacher teacher = getTeacher(rc.getUid());

        if (teacher.getStuNum() <= stuCap)
            teacher.setStuCap(stuCap);
        else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"当前人数高于要设置的上限，请删除后重新设置");
        return teacher.getStuCap();
    }
    public Student deleteStudent(int sid) {
        Teacher teacher = getTeacher(rc.getUid());
        List<Student> students = teacher.getStudents();
        Student s = null;
        for (int i = 0; i < students.size(); i ++) {
             s = students.get(i);
            if (s.getId() == sid) {
                s.setTeacher(null);
                teacher.setStuNum(teacher.getStuNum() - 1);
                break;
            }
    }
        return s;
    }
}
