package com.realscores.tasks.course;

import android.os.AsyncTask;

import com.realscores.obj.Course;
import com.realscores.util.HttpRequestUtil;

/**
 * Created by Mitch on 14/08/2017.
 */
public class GetAllCoursesTask extends AsyncTask<Void, Void, Course[]> {


  @Override
  protected Course[] doInBackground(Void... params) {
    return (Course[]) HttpRequestUtil.getJsonObjects(new String[]{""}, new Course[]{});
  }
}
