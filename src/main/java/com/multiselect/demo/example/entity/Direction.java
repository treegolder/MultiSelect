package com.multiselect.demo.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"courses"})
public class Direction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min=2,max=10,message = "请输入正确的方向名称")
    private String name;

    @OneToMany(mappedBy = "direction")
    private List<Course> courses;
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
