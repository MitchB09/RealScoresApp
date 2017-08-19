package com.realscores.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.realscores.R;
import com.realscores.activity.fragments.NavDrawerFragment;
import com.realscores.activity.fragments.NavDrawerFragment.NavigationDrawerCallbacks;

/**
 * Created by Mitch on 19/08/2017.
 */
public class BaseActivity extends ActionBarActivity implements NavigationDrawerCallbacks {

  private NavDrawerFragment mNavigationDrawerFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  protected void setUpNavigationDrawer() {
    mNavigationDrawerFragment = (NavDrawerFragment)
        getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);

    mNavigationDrawerFragment.setUp(
        R.id.navigation_drawer,
        (DrawerLayout) findViewById(R.id.drawer_layout));
  }

  @Override
  public void onNavigationDrawerItemSelected(int position) {
    // update the main content by replacing fragments
    Log.e("Nav Item", "SELECTED Nav Menu Item");
    FragmentManager fragmentManager = getSupportFragmentManager();
    Toast.makeText(getBaseContext(), "Selected item" + String.valueOf(position), Toast.LENGTH_LONG).show();
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
