package com.nimsoc.spring.model;

import java.util.Objects;

public class Student {
  private String name;
  private String emailId;
  private int courseId;

  public Student(String name, String emailId, int courseId) {
    this.name = name;
    this.emailId = emailId;
    this.courseId = courseId;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Student student = (Student) o;
    return Objects.equals(name, student.name) && Objects.equals(emailId, student.emailId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, emailId);
  }

  public int getCourseId() {
    return courseId;
  }

  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Student{");
    sb.append("name='").append(name).append('\'');
    sb.append(", emailId='").append(emailId).append('\'');
    sb.append(", courseId=").append(courseId);
    sb.append('}');
    return sb.toString();
  }

  public Student() {
  }
}
