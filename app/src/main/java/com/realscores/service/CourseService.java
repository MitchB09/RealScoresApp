package com.realscores.service;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.realscores.obj.Course;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by Mitch on 10/08/2017.
 */
public class CourseService  extends AsyncTask<Integer, Void, Course> implements ICourseService  {

  private Context context;

  public CourseService(Context context){
    this.context = context;
  }

    public List<Course> getAllCourses(){
        throw new UnsupportedOperationException("Do Me Later Please");
    }

    public Course getCourseById(int courseId){
      return doInBackground(courseId);
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


  @Override
  protected Course doInBackground(Integer ... courseIds) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      HttpClient client = new DefaultHttpClient();
      HttpGet httpGet = new HttpGet("http://192.168.2.12:8080/courses/" + String.valueOf(courseIds[0]));
      try {
        HttpResponse response = client.execute(httpGet);
        StatusLine statusLine = response.getStatusLine();
        int statusCode = statusLine.getStatusCode();
        if (statusCode == 200) {
          HttpEntity entity = response.getEntity();
          InputStream content = entity.getContent();
          BufferedReader reader = new BufferedReader(
              new InputStreamReader(content));
          String line;
          while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
          }
        } else {
          Log.e("JSON", "Failed to download file");
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      ObjectMapper ojbMapper = new ObjectMapper();
      return ojbMapper.readValue(stringBuilder.toString(),Course.class);
    } catch (Exception ex) {
      Log.wtf("Other Stuff", ex.getMessage());
      throw new RuntimeException(ex);
    }
  }

  protected void onPostExecute(Course course){
    try {
      //---print out the content of the json feed---
      Toast.makeText(context, String.valueOf(course.getCourseId()) + " - " + course.getName(),
          Toast.LENGTH_SHORT).show();
      } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
