package com.multiselect.demo.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Student {
    @Id
    @Column(unique = true)
    private String sno;
    private String name;
    private String sex;

    @ManyToOne
    private Teacher teacher;

    /**
     * 学生和课是many to many
     */
    @OneToMany(mappedBy = "student")
    private List<SC> sc;

}
