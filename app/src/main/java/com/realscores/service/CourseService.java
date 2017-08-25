package com.realscores.service;

import android.content.Context;

import com.realscores.obj.Course;
import com.realscores.tasks.course.GetAllCoursesTask;
import com.realscores.tasks.course.GetCourseTask;

import java.util.concurrent.ExecutionException;

/**
 * Created by Mitch on 10/08/2017.
 */
public class CourseService implements ICourseService  {

  private Context context;

  public CourseService(Context context){
    this.context = context;
  }

    public Course[] getAllCourses(){
      try {
        return new GetAllCoursesTask().execute().get();
      } catch (InterruptedException | ExecutionException e){
        throw new RuntimeException(e);
      }
    }

    public Course getCourseById(int courseId) throws Exception{
      return new GetCourseTask().execute(courseId).get();
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
