package com.multiselect.demo;


import com.multiselect.demo.example.interceptor.LoginInterceptor;
import com.multiselect.demo.example.interceptor.StudentInterceptor;
import com.multiselect.demo.example.interceptor.TeacherInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;
    @Autowired
    private TeacherInterceptor teacherInterceptor;
    @Autowired
    private StudentInterceptor studentInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {//注入拦截器注册对象
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/login");

        registry.addInterceptor(teacherInterceptor)
                .addPathPatterns("/api/teacher/**");
        registry.addInterceptor(studentInterceptor)
                .addPathPatterns("/api/student/**");
    }
}
