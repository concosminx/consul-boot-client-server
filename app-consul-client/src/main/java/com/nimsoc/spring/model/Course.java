package com.nimsoc.spring.model;

import java.util.Objects;

public class Course {

  private int courseId;
  private String courseName;
  private int fees;

  public int getCourseId() {
    return courseId;
  }

  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public int getFees() {
    return fees;
  }

  public void setFees(int fees) {
    this.fees = fees;
  }

  public Course(int courseId, String courseName, int fees) {
    this.courseId = courseId;
    this.courseName = courseName;
    this.fees = fees;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Course course = (Course) o;
    return courseId == course.courseId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(courseId);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Course{");
    sb.append("courseId=").append(courseId);
    sb.append(", courseName='").append(courseName).append('\'');
    sb.append(", fees=").append(fees);
    sb.append('}');
    return sb.toString();
  }

  public Course() {
  }
}
