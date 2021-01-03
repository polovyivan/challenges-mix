package com.ivan.polovyi.challeges.cacheannotations.service;

import com.ivan.polovyi.challeges.cacheannotations.domain.Student;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StudentService {

  private List<Student> studentList = new ArrayList<>();


  public void createStudent(Student student) {
    studentList.add(student);
  }

  @CacheEvict(cacheNames = "student")
  public void deleteStudent(Integer id) {
    log.info("Removing student by Id {}", id);
    studentList.removeIf(s -> s.getId().equals(id.toString()));
  }

  @Cacheable(cacheNames = "student")
  public Student getStudentById(Integer id) {
    log.info("Getting student by Id {}", id);
    return studentList.stream().filter(s -> s.getId().equals(id.toString())).findFirst()
        .orElseThrow(() -> new RuntimeException("Student not found"));
  }

  public List<Student> getAll() {
    return studentList;
  }
}
