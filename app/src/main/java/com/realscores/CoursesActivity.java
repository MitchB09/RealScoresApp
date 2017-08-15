package com.realscores;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.realscores.obj.Course;
import com.realscores.service.CourseService;
import com.realscores.service.ICourseService;

public class CoursesActivity extends ActionBarActivity {

    private ICourseService courseService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.courses_activity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.courses_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
      int id = item.getItemId();

      //noinspection SimplifiableIfStatement
      if (id == R.id.action_settings) {
          return true;
      } else {
        if (id == R.id.course1) {
          //Course course = courseService.getCourseById(1);

          try {
            Course course = new CourseService(getBaseContext()).execute(1).get();
            TextView txtVw = (TextView)findViewById(R.id.Course);
            txtVw.setText(course.getCourseId() + " " + course.getName());

          } catch (Exception ex) {
            Log.wtf("Other Stuff", ex.getMessage());
            throw new RuntimeException(ex);
          }
        }
      }
      return super.onOptionsItemSelected(item);
    }


  private void setCourseText(int courseId){

  }
}
