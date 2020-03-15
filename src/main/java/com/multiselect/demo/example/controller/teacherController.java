package com.multiselect.demo.example.controller;

import com.multiselect.demo.example.entity.Course;
import com.multiselect.demo.example.entity.Direction;
import com.multiselect.demo.example.entity.Teacher;
import com.multiselect.demo.example.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
@Slf4j
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

           return "redirect:/tea/load";
       }else{
           return "index";
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
        ts.setWeight(id,cno,weight);
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

        ts.updateSum(sum, session);

        return "redirect:/tea/load";
    }

    @PostMapping("/updatethreshold")
    public String updateThreshold(@RequestParam("threshold") double threshold, @RequestParam("id") int id){
        ts.updateThreshold(threshold, id);

        return "redirect:/tea/load";
    }



}
