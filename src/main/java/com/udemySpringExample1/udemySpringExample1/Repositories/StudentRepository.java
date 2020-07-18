package com.udemySpringExample1.udemySpringExample1.Repositories;

import com.udemySpringExample1.udemySpringExample1.Model.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * Created JPA repository for Student Entity
 */
public interface StudentRepository extends CrudRepository<Student, Integer> {
}
