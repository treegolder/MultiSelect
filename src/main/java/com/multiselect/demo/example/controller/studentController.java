package com.multiselect.demo.example.controller;

import com.multiselect.demo.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/stu")
public class studentController {
    @Autowired
    StudentService ss;
    @RequestMapping("/loginPage")
    public String loginPage(){
        return "login";
    }

    @PostMapping ("/login")
    public String login(@RequestParam("sno")String sno, HttpSession session){
     String flag = ss.login(sno,session);
     if (flag.equals("1")){
         return "tpage";
     }else{
         return "index";
     }

    }
}
