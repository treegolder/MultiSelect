package com.multiselect.demo.example.service;

import com.multiselect.demo.example.entity.Course;
import com.multiselect.demo.example.entity.Direction;
import com.multiselect.demo.example.entity.Teacher;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface TeacherService {
    String login(String id, String password,HttpSession session);

    List<Direction> DireList();

    List<Course> CourList();

    void setWeight(int id, int cno, double weight);
    void updateSum(int sum,HttpSession session);
    void updateThreshold(double threshold,int id);
}
