package com.spring.course_application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.course_application.Dao.CourseDao;
import com.spring.course_application.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId) {
        Optional<Course> optionalCourse = courseDao.findById(courseId);
        return optionalCourse.orElseThrow(() -> new RuntimeException("Course not found with id: " + courseId));
    }

    @Override
    public Course addCourse(Course course) {
        courseDao.save(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        courseDao.save(course);
        return course;
    }

    @Override
    public void deleteCourse(long courseId) {
        Course entity = courseDao.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + courseId));
        courseDao.delete(entity);
    }
}