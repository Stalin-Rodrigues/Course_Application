package com.spring.course_application.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.course_application.entities.Course;

public interface CourseDao extends JpaRepository<Course, Long> {

} 