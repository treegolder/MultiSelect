package com.multiselect.demo.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.sql.Update;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
public class SC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Max(value = 100, message = "百分制成绩不能超过100分")
    private double score;
    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;
   /* @ManyToOne(cascade =CascadeType.ALL)
    private Course course;*/

    private String courseName;
    private  int number;
    @Column(columnDefinition = "timestamp default current_timestamp",
            insertable = false,
            updatable = false)
    private LocalDateTime insertTime;

    @Column(columnDefinition = "timestamp default current_timestamp",
            insertable = false,
            updatable = false)
    private LocalDateTime updateTime;
}
