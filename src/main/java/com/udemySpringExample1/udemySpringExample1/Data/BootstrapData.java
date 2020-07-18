package com.udemySpringExample1.udemySpringExample1.Data;

import com.udemySpringExample1.udemySpringExample1.Model.Subject;
import com.udemySpringExample1.udemySpringExample1.Repositories.StudentRepository;
import com.udemySpringExample1.udemySpringExample1.Repositories.SubjectRepository;
import com.udemySpringExample1.udemySpringExample1.Repositories.TeacherRepository;
import com.udemySpringExample1.udemySpringExample1.Model.Student;
import com.udemySpringExample1.udemySpringExample1.Model.Teacher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final SubjectRepository subjectRepository;

    public BootstrapData(StudentRepository studentRepository, TeacherRepository teacherRepository, SubjectRepository subjectRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Student s1, s2;
        Teacher t1, t2;
        Subject sub1, sub2;

        s1 = new Student(101, "abc");
        s2 = new Student(102, "pqr");

        t1 = new Teacher(11, "mno");
        t2 = new Teacher(12, "xyz");

        s1.getTeachers().add(t1);
        t1.getStudents().add(s1);
        s2.getTeachers().add(t2);
        t2.getStudents().add(s2);

        sub1 = new Subject("Hindi","Language subject");
        sub2 = new Subject("Computer Science","Engineering subject");

        try {
            teacherRepository.save(t1);
            studentRepository.save(s1);

            teacherRepository.save(t2);
            studentRepository.save(s2);

            subjectRepository.save(sub1);
            subjectRepository.save(sub2);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Started Bootstrap data initialization:");
        System.out.println("No. of student: " + studentRepository.count());
        System.out.println("No. of teachers: " + teacherRepository.count());
        System.out.println("No. of subject: " + subjectRepository.count());

    }
}
