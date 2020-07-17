package Model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int teacherId;

    private String teacherName;

    @ManyToMany(mappedBy = "teachers")
    private List<Student> students;

    public Teacher(){

    }

    public Teacher(int teacherId, String teacherName, List<Student> students){
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.students = students;
    }

    public void setTeacherId(int teacherId){
        this.teacherId = teacherId;
    }

    public void setTeacherName(String teacherName){
        this.teacherName = teacherName;
    }

    public void setStudents(List<Student> students){
        this.students = students;
    }

    public  int getTeacherId(){
        return teacherId;
    }

    public  String getTeacherName(){
        return teacherName;
    }

    public List<Student> getStudents(){
        return students;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", students=" + students +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return teacherId == teacher.teacherId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId);
    }
}
