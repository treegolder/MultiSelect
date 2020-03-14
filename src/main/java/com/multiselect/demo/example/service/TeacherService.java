package com.multiselect.demo.example.service;

import com.multiselect.demo.example.entity.Teacher;

import javax.servlet.http.HttpSession;

public interface TeacherService {
    public String login(String id, String password, HttpSession session);
    public void setWeight();
}
