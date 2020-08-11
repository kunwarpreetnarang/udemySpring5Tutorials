package com.udemySpringExample1.udemySpringExample1.udemystudent.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created Teacher Entity POJO
 */
@Entity
@EqualsAndHashCode(exclude = {"students"})
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int teacherId;

    private String teacherName;

    /*
        NOTE: when using the @ManyToMany annotation, always use a java.util.Set and avoid the java.util.List to avoid transient errors.
     */
    @ManyToMany(mappedBy = "teachers")
    private List<Student> students = new ArrayList<>();

    public Teacher() {

    }

    public Teacher(int teacherId, String teacherName) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
    }

}
