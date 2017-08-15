package com.realscores.service;

import com.realscores.obj.Course;

/**
 * Created by Mitch on 10/08/2017.
 */
public interface ICourseService {
    Course[] getAllCourses() throws Exception;
    Course getCourseById(int courseId) throws Exception;
    boolean addCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(int courseId);
}
