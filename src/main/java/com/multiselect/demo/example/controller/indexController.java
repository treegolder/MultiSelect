package com.multiselect.demo.example.controller;

import com.multiselect.demo.example.entity.Course;
import com.multiselect.demo.example.entity.Direction;
import com.multiselect.demo.example.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
public class indexController {
    @Autowired
    TeacherService ts;
    @RequestMapping("/index")
    public String index(Model model){

        return "index";
    }



}
