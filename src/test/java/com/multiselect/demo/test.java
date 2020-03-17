package com.multiselect.demo;

import com.multiselect.demo.example.entity.Direction;
import com.multiselect.demo.example.repository.DirectionRepository;
import com.multiselect.demo.example.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class test {
    @Autowired
    private DirectionRepository directionRepository;
    @Autowired
    TeacherService ts;
    @Test
    public void test(){
        List<Direction> list = directionRepository.findAll();
        for (Direction d:list){
            System.out.println(d.getName());
        }

    }
    public void test1(){


    }

}
