package com.multiselect.demo.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@JsonIgnoreProperties({"sc"})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @MapsId
    private User user; //依靠单向@OneToOne和@MapsId，与父表共享主键

    private String direction;

    @OneToMany(mappedBy = "student", cascade = CascadeType.REMOVE)
    private List<SC> sc;

    @ManyToOne
    private Teacher teacher;

    @Column(columnDefinition = "timestamp default current_timestamp",
            insertable = false,
            updatable = false)
    private LocalDateTime insertTime;

}
