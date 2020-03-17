package com.multiselect.demo.example.controller;

import com.multiselect.demo.example.entity.Course;
import com.multiselect.demo.example.entity.Direction;
import com.multiselect.demo.example.entity.Teacher;
import com.multiselect.demo.example.service.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpSession;
import java.util.List;

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

        Teacher teacher = ts.login(id);

         if (teacher != null) {
           if (teacher.getPassword().equals(psd)){
              session.setAttribute("teacher", teacher);
               return "redirect:/tea/load";//登陆成功
           }else{
               return "index";//登陆失败
           }
       }else {
           return "index";//登陆失败
       }

    }

    @RequestMapping("/load")
    public String Load(Model model){
        List<Direction> direList = ts.DireList();
        List<Course> courList = ts.CourList();
        model.addAttribute("directionList", direList);
        model.addAttribute("courseList", courList);
        return "tpage";
    }


    @PostMapping("/setweight")
    public String setWeight(int id,int cno,double weight){
        ts.updateWeight(id,cno,weight);
        //String flag = "1";

        return "redirect:/tea/load";

    }

    /**
     * 设定人数上限
     * @param sum
     * @param session
     * @return
     */
    @PostMapping ("/updatesum")
    public String setSum(@RequestParam("sum") int sum,HttpSession session){
     Teacher teacher = (Teacher) session.getAttribute("teacher");

        ts.updateSum(sum, teacher);

        return "redirect:/tea/load";
    }

    @PostMapping("/updatethreshold")
    public String updateThreshold(@RequestParam("threshold") double threshold, @RequestParam("id") int id){
        ts.updateThreshold(threshold, id);

        return "redirect:/tea/load";
    }



}
