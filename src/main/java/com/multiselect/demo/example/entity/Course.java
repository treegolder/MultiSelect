package com.multiselect.demo.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@JsonIgnoreProperties({"studentCourse"})
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min = 2, max = 10,message = "请输入正确的课程名称")
    private String name;

    //private int grade;

    private double weight;

    /*@OneToMany(mappedBy = "course", cascade = CascadeType.REMOVE)
    private List<SC> studentCourses;*/

    @ManyToOne
    private Direction direction;
    @ManyToOne
    private Teacher teacher;

    @Column(columnDefinition = "timestamp default current_timestamp",
            insertable = false,
            updatable = false)
    private LocalDateTime insertTime;

    @Column(columnDefinition = "timestamp default current_timestamp",
            insertable = false,
            updatable = false)
    private LocalDateTime updateTime;


}
