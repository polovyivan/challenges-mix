package com.ivan.polovyi.challeges.cacheannotations.controller;

import com.ivan.polovyi.challeges.cacheannotations.domain.Student;
import com.ivan.polovyi.challeges.cacheannotations.repository.StudentRedisRepository;

import com.ivan.polovyi.challeges.cacheannotations.service.StudentService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class StudentController {

  @Autowired
  private StudentRedisRepository studentRedisRepository;

  @Autowired
  private StudentService studentService;


  @PostMapping("v1/students")
  public void createStudent(@RequestBody Student student) {
    studentRedisRepository.save(student);
  }

  @GetMapping("/v1/students")
  public List<Student> getAllStudents() {
    return StreamSupport.stream(studentRedisRepository.findAll().spliterator(), true).collect(
        Collectors.toList());
  }


  @PostMapping("/v2/students")
  public void createStudentV2(@RequestBody Student student) {
     studentService.createStudent(student);
  }

  @DeleteMapping("/v2/students/{id}")
  public void deleteStudent(@PathVariable Integer id) {
     studentService.deleteStudent(id);
  }

  @GetMapping("/v2/students/{id}")
  public Student getStudentById(@PathVariable Integer id) {
    return studentService.getStudentById(id);
  }

  @GetMapping("/v2/students")
  public List<Student> getAll() {
    return studentService.getAll();
  }

}
