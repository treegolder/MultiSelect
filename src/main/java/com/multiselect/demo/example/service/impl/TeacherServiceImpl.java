package com.multiselect.demo.example.service.impl;

import com.multiselect.demo.example.entity.Teacher;
import com.multiselect.demo.example.repository.TeacherRepository;
import com.multiselect.demo.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
    @Autowired
   private TeacherRepository tr;

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
}
