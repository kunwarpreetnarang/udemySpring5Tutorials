package com.udemySpringExample1.udemySpringExample1.Repositories;

import com.udemySpringExample1.udemySpringExample1.Model.Teacher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created JPA repository for Teacher Entity
 */
public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
}
