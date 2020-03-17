package com.multiselect.demo.example.service;

import com.multiselect.demo.example.entity.Course;
import com.multiselect.demo.example.entity.Direction;
import com.multiselect.demo.example.entity.Teacher;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface TeacherService {
    Teacher login(String id);

    /**
     * 获取全部方向
     * @return
     */
    List<Direction> DireList();

    /**
     * 获取全部课程
     * @return
     */
    List<Course> CourList();

    /**
     * 添加权重
     * @param id
     * @param cno
     * @param weight
     */
    void updateWeight(int id, int cno, double weight);

    /**
     * 添加人数上限
     * @param sum
     * @param teacher
     */
    void updateSum(int sum,Teacher teacher);

    /**
     * 设定最低分
     * @param threshold
     * @param id id为方向的id，分数是方向和课程的属性
     */
    void updateThreshold(double threshold,int id);
}
