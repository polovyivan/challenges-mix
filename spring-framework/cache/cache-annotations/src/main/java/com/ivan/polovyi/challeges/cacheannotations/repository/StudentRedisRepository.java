package com.ivan.polovyi.challeges.cacheannotations.repository;

import com.ivan.polovyi.challeges.cacheannotations.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRedisRepository extends CrudRepository<Student, String> {

}
