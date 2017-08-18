package com.realscores;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.realscores.NavDrawerFragment.NavigationDrawerCallbacks;
import com.realscores.obj.Course;
import com.realscores.service.CourseService;
import com.realscores.service.ICourseService;

public class CoursesActivity extends ActionBarActivity implements NavigationDrawerCallbacks {

  private ICourseService courseService = new CourseService(getBaseContext());

  private NavDrawerFragment mNavigationDrawerFragment;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.courses_activity);

    mNavigationDrawerFragment = (NavDrawerFragment)
        getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);

    mNavigationDrawerFragment.setUp(
        R.id.navigation_drawer,
        (DrawerLayout) findViewById(R.id.drawer_layout));
  }

  @Override
  public void onNavigationDrawerItemSelected(int position) {
    // update the main content by replacing fragments
    FragmentManager fragmentManager = getSupportFragmentManager();
    fragmentManager.beginTransaction()
        .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
        .commit();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.courses_menu, menu);
    return true;
  }

  @Override
  public boolean onPrepareOptionsMenu(Menu menu) {
    menu.clear();

    try{
      Course[] courses = courseService.getAllCourses();

      for (Course course: courses){
        menu.add(0, course.getCourseId(), course.getCourseId(), course.getName());
      }
    } catch (Exception ex){
      Log.wtf("Bad Things Happended", ex);
    }
    return super.onPrepareOptionsMenu(menu);
  }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
      int id = item.getItemId();

      //noinspection SimplifiableIfStatement
      if (id == R.id.action_settings) {
          return true;
      }
      /*else {
        try {
          Course course = courseService.getCourseById(id);
          TextView txtVw = (TextView) findViewById(R.id.Course);
          txtVw.setText(course.getCourseId() + " " + course.getName());

        } catch (Exception ex) {
          Log.wtf("Other Stuff", ex.getMessage());
          throw new RuntimeException(ex);
        }
      }*/
      return super.onOptionsItemSelected(item);
    }


  private void setCourseText(int courseId){

  }

  public static class PlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public PlaceholderFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber) {
      PlaceholderFragment fragment = new PlaceholderFragment();
      Bundle args = new Bundle();
      args.putInt(ARG_SECTION_NUMBER, sectionNumber);
      fragment.setArguments(args);
      return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View rootView = inflater.inflate(R.layout.fragment_main, container, false);
      return rootView;
    }
  }
}
