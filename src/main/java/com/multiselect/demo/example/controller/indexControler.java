package com.multiselect.demo.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexControler {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
