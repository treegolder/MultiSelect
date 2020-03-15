package com.multiselect.demo.example.service.impl;

import com.multiselect.demo.example.entity.Course;
import com.multiselect.demo.example.entity.DC;
import com.multiselect.demo.example.entity.Direction;
import com.multiselect.demo.example.entity.Teacher;
import com.multiselect.demo.example.repository.CourseRepository;
import com.multiselect.demo.example.repository.DCRepository;
import com.multiselect.demo.example.repository.DirectionRepository;
import com.multiselect.demo.example.repository.TeacherRepository;
import com.multiselect.demo.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.util.List;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
    @Autowired
   private TeacherRepository tr;
    @Autowired
    private DirectionRepository dr;
    @Autowired
    private CourseRepository cr;
    @Autowired
    private DCRepository dcr;
    @Override
    public String login(String id, String password, HttpSession session) {
       Teacher teacher = tr.findById(id).orElse(null);
       if (teacher != null) {
           if (teacher.getPassword().equals(password)){
              session.setAttribute("teacher", teacher);
               return "1";//登陆成功
           }else{
               return "0";//登陆失败
           }
       }else {
           return "0";//登陆失败
       }
    }

    /**
     * 获取全部方向
     * @return
     */
    @Override
    public  List<Direction> DireList() {
       List<Direction> list = dr.findAll();
       return list;
    }

    /**
     * 获取全部课程
     * @return
     */
    @Override
    public List<Course> CourList() {
        List<Course> list = cr.findAll();
        return list;
    }

    @Override
    public void setWeight(int id,int cno,double weight) {
        Direction direction = dr.findById(id).orElse(null);
        Course course = cr.findById(cno).orElse(null);
        DC dc = new DC();
        dc.setDirection(direction);
        dc.setCourse(course);
        dc.setWeight(weight);
        dcr.save(dc);

    }

    @Override
    public void updateSum(int sum, HttpSession session) {
       Teacher teacher = (Teacher) session.getAttribute("teacher");
        tr.updateSum(teacher.getId(),sum);
    }

    @Override
    public void updateThreshold(double threshold, int id) {
        dcr.updateThreshold(threshold, id);
    }
}
