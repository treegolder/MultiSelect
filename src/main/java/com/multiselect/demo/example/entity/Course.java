package com.multiselect.demo.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cno;
    private String Cname;

    @OneToMany(mappedBy = "course")
    private List<SC> sc;

    @OneToMany(mappedBy = "course")
    private List<DC> dc;
}
