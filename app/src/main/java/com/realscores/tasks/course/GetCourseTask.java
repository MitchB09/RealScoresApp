package com.realscores.tasks.course;

import android.os.AsyncTask;

import com.realscores.obj.Course;
import com.realscores.util.HttpRequestUtil;

/**
 * Created by Mitch on 14/08/2017.
 */
public class GetCourseTask extends AsyncTask<Integer, Void, Course> {

  @Override
  protected Course doInBackground(Integer ... courseIds) {
    return (Course)HttpRequestUtil.getJsonObject(courseIds, new Course());
  }
}
