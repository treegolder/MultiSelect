package com.multiselect.demo.example.controller;

import com.multiselect.demo.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/tea")
public class teacherController {
    @Autowired
    private TeacherService ts;

    @RequestMapping("/loginPage")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("id") String id, @RequestParam("password") String psd, HttpSession session) {
        String flag = ts.login(id,psd,session);
       if (flag.equals("1")){
           return "success";
       }else{
           return "index";
       }
    }
    @RequestMapping("/dire")
    public void setWeight(){


    }

}
