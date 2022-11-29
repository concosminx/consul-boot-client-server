package com.nimsoc.spring.controllers;

import com.nimsoc.spring.dto.StudentDTO;
import com.nimsoc.spring.model.Course;
import com.nimsoc.spring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentController {

  @LoadBalanced
  @Autowired
  private RestTemplate restTemplate;

  //just for demo
  private List<Student> students = new ArrayList<>();

  @PostConstruct
  public void init() {
    students.add(new Student("John Doe", "johndoe@gmail.com", 1));
    students.add(new Student("Jane Doe", "janedoe@gmail.com", 2));
  }

  private StudentDTO getStudentDTO(Student student) {
    String url = "http://Consul-Service/courses/details/"+student.getCourseId();
    Course c = restTemplate.getForObject(url, Course.class);
    return new StudentDTO(student.getName(), student.getEmailId(), c);
  }

  @GetMapping("/list")
  public List<StudentDTO> getStudents() {
    List<StudentDTO> collect = students.stream().map(this::getStudentDTO).collect(Collectors.toList());
    return collect;
  }

}
