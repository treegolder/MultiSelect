package com.multiselect.demo.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter@Setter
@NoArgsConstructor
public class Teacher {
    @Id
    private String id;
    private String password;

    @OneToMany(mappedBy = "teacher")
    private List<Student> student;
}
