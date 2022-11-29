package com.nimsoc.spring.dto;

import com.nimsoc.spring.model.Course;

import java.util.Objects;

public class StudentDTO {

  private String name;
  private String emailId;
  private Course course;

  public StudentDTO() {
  }

  public StudentDTO(String name, String emailId, Course course) {
    this.name = name;
    this.emailId = emailId;
    this.course = course;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmailId() {
    return emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    StudentDTO that = (StudentDTO) o;
    return Objects.equals(name, that.name) && Objects.equals(emailId, that.emailId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, emailId);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("StudentDTO{");
    sb.append("name='").append(name).append('\'');
    sb.append(", emailId='").append(emailId).append('\'');
    sb.append(", course=").append(course);
    sb.append('}');
    return sb.toString();
  }
}
