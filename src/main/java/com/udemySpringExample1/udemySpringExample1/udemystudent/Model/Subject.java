package com.udemySpringExample1.udemySpringExample1.udemystudent.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@EqualsAndHashCode(exclude = {"student"})
@Data
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sub_id;

    private String subjectName;
    private String subjectDescription;

    @OneToMany
    @JoinColumn(name="subject_id")
    Set<Student> student = new HashSet<Student>();

    public Subject(){

    }

    public Subject(String subjectName, String subjectDescription) {
        this.subjectName = subjectName;
        this.subjectDescription = subjectDescription;
    }


}
