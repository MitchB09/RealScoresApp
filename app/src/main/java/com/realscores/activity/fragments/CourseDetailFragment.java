package com.realscores.activity.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.realscores.R;
import com.realscores.obj.Course;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CourseDetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CourseDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CourseDetailFragment extends Fragment {
  // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
  public static final String COURSE = "course";

  private Course course;

  private OnFragmentInteractionListener mListener;

  public CourseDetailFragment() {
    // Required empty public constructor
  }

  /**
   * Use this factory method to create a new instance of
   * this fragment using the provided parameters.
   *
   * @param course Course
   * @return A new instance of fragment CourseDetailFragment.
   */
  public static CourseDetailFragment newInstance(Course course) {
    CourseDetailFragment fragment = new CourseDetailFragment();
    Bundle args = new Bundle();
    args.putSerializable(COURSE, course);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_course_detail, container, false);
    TextView tv = (TextView)view.findViewById(R.id.courseDetailName);
    tv.setText(course.getName());
    return view;
  }

  @Override
  public void onAttach(Activity activity) {
    super.onAttach(activity);
    if (course == null) {
      course = (Course)getArguments().getSerializable(COURSE);
    }
    showGlobalContextActionBar();
  }

  @Override
  public void onDetach() {
    super.onDetach();
    mListener = null;
  }

  private void showGlobalContextActionBar() {
    ActionBar actionBar = getActionBar();
    actionBar.setDisplayShowTitleEnabled(true);
    actionBar.setTitle(course.getName());
  }

  private ActionBar getActionBar() {
    return ((ActionBarActivity) getActivity()).getSupportActionBar();
  }

  /**
   * This interface must be implemented by activities that contain this
   * fragment to allow an interaction in this fragment to be communicated
   * to the activity and potentially other fragments contained in that
   * activity.
   * <p>
   * See the Android Training lesson <a href=
   * "http://developer.android.com/training/basics/fragments/communicating.html"
   * >Communicating with Other Fragments</a> for more information.
   */
  public interface OnFragmentInteractionListener {
    // TODO: Update argument type and name
    void onFragmentInteraction(Uri uri);
  }
}
