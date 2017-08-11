package com.realscores.service;

import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.realscores.obj.Course;

import java.net.URL;
import java.util.List;

/**
 * Created by Mitch on 10/08/2017.
 */
public class CourseService implements ICourseService {

    public List<Course> getAllCourses(){
        throw new UnsupportedOperationException("Do Me Later Please");
    }

    public Course getCourseById(int courseId){

        try {
          URL url = new URL("http://192.168.2.12:8080/courses/" + String.valueOf(courseId));
          ObjectMapper ojbMapper = new ObjectMapper();
          Course course = ojbMapper.readValue(url,Course.class);
          return course;
        } catch (Exception ex) {
          Log.wtf("Other Stuff", ex.getMessage());
          throw new RuntimeException(ex);
        }
    }

    public boolean addCourse(Course course){
        throw new UnsupportedOperationException("Do Me Later Please");
    }

    public void updateCourse(Course course){
        throw new UnsupportedOperationException("Do Me Later Please");
    }

    public void deleteCourse(int courseId){
        throw new UnsupportedOperationException("Do Me Later Please");
    }


}
