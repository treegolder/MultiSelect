package com.multiselect.demo.example.component;


import com.multiselect.demo.example.entity.Teacher;
import com.multiselect.demo.example.entity.User;
import com.multiselect.demo.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

//系统初始化之后调用该组件
@Component
@Slf4j
@Transactional
public class InitComponent implements InitializingBean {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UserService userService;

    @Override
    public void afterPropertiesSet() throws Exception {
        int number = 1001;
        User user = userService.getUser(number);
        if(user ==null){
            User u = new User();
            u.setName("BO");
            u.setNumber(number);
            u.setRole(User.Role.TEACHER);
            u.setPassword(encoder.encode(String.valueOf(number)));
            Teacher t = new Teacher();
            t.setStuCap(0);
            t.setStuNum(0);
            //级联持久化
            t.setUser(u);
            userService.addTeacher(t);
        }



    }
}
