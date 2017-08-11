package com.realscores.service;

import com.realscores.obj.Course;

import java.util.List;

/**
 * Created by Mitch on 10/08/2017.
 */
public interface ICourseService {
    List<Course> getAllCourses();
    Course getCourseById(int courseId);
    boolean addCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(int courseId);
}
