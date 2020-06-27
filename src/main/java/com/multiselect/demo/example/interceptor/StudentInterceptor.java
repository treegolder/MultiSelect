package com.multiselect.demo.example.interceptor;

import com.multiselect.demo.example.component.RequestComponent;
import com.multiselect.demo.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class StudentInterceptor implements HandlerInterceptor{

        @Autowired
        private RequestComponent requestComponent;

        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            if(requestComponent.getRole()!= User.Role.STUDENT){
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"无权限");
            }
            return true;
        }
    }

