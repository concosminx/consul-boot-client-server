package com.nimsoc.spring.controllers;

import com.nimsoc.spring.model.Course;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/courses")
public class CourseController {

  //just as demo, not thread safe
  private Map<Integer, Course> coursesMap = new HashMap<>();

  @PostConstruct
  public void init() {
    coursesMap.put(1, new Course(1, "Data Science", 200));
    coursesMap.put(2, new Course(2, "Biology", 200));
    coursesMap.put(3, new Course(3, "Math", 500));
  }

  @GetMapping(value = "/details/{courseId}")
  public Course getCourse(@PathVariable("courseId") int courseId) {
    return coursesMap.get(Integer.valueOf(courseId));
  }
}
