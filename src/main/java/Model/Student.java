package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import java.util.List;
import java.util.Objects;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;

    private String studentName;

    @ManyToMany
    @JoinTable(name = "student_teacher", joinColumns = @JoinColumn(name="student_id"),
               inverseJoinColumns = @JoinColumn(name="teacher_id"))
    private List<Teacher> teachers;

    public Student(){

    }

    public Student(int studentId, String studentName, List<Teacher> teachers){
        this.studentId = studentId;
        this.studentName = studentName;
        this.teachers = teachers;
    }

    public void setStudentId(int studentId){
        this.studentId = studentId;
    }

    public void setStudentName(String studentName){
        this.studentName = studentName;
    }

    public void setTeachers(List<Teacher> teachers){
        this.teachers = teachers;
    }

    public  int getStudentId(){
        return studentId;
    }

    public  String getStudentName(){
        return studentName;
    }

    public List<Teacher> getTeachers()
    {
        return teachers;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", teachers=" + teachers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId == student.studentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }
}
