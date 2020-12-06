package com.udemySpringExample1.udemySpringExample1.udemystudent.Data;

import com.udemySpringExample1.udemySpringExample1.udemystudent.Model.Subject;
import com.udemySpringExample1.udemySpringExample1.udemystudent.Repositories.StudentRepository;
import com.udemySpringExample1.udemySpringExample1.udemystudent.Repositories.SubjectRepository;
import com.udemySpringExample1.udemySpringExample1.udemystudent.Repositories.TeacherRepository;
import com.udemySpringExample1.udemySpringExample1.udemystudent.Model.Student;
import com.udemySpringExample1.udemySpringExample1.udemystudent.Model.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
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
        Student s1;
        Student s2;
        Teacher t1;
        Teacher t2;
        Subject sub1;
        Subject sub2;

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

            s1.setSubject(sub1);
            s1.setSubject(sub2);
            s2.setSubject(sub1);
            s2.setSubject(sub2);
            sub1.getStudent().add(s1);
            sub2.getStudent().add(s2);
            sub1.getStudent().add(s2);
            sub2.getStudent().add(s1);
            t1.setTeacherName("wiojr");

        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("Started Bootstrap data initialization:");
        log.info("No. of student: " + studentRepository.count());
        log.info("No. of teachers: " + teacherRepository.count());
        log.info("No. of subject: " + subjectRepository.count());
        log.info("Subject with no. of students: \n sub1: " + sub1.getStudent().size() + " sub2: " + sub2.getStudent().size());
    }
}
