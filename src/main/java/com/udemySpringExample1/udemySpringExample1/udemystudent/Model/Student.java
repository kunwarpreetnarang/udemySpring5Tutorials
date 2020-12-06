package com.udemySpringExample1.udemySpringExample1.udemystudent.Model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created Student Entity POJO
 */
@Data
//add this to avoid circular reference
@EqualsAndHashCode(exclude = {"teachers"})
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    private int studentId;

    private String studentName;

    /*
        NOTE: when using the @ManyToMany annotation, always use a java.util.Set and avoid the java.util.List to avoid transient errors.
     */
    @ManyToMany
    @JoinTable(name = "student_teacher", joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private List<Teacher> teachers = new ArrayList<>();

    @ManyToOne
    Subject subject;

    public Student() {

    }

    public Student(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

}
