package com.udemySpringExample1.udemySpringExample1.Repositories;

import com.udemySpringExample1.udemySpringExample1.Model.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepository extends CrudRepository<Subject, Integer> {
}
