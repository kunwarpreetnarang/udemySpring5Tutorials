package com.udemySpringExample1.udemySpringExample1.udemystudent.Repositories;

import com.udemySpringExample1.udemySpringExample1.udemystudent.Model.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepository extends CrudRepository<Subject, Integer> {
}
