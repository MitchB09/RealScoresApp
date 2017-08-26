package com.realscores.obj;

import android.app.Fragment;

import com.realscores.activity.fragments.CourseFragment;

/**
 * Created by Mitch on 26/08/2017.
 */

public enum MainNavigationItemsEnum {

  HOME(0, CourseFragment.class),
  COURSES(1, CourseFragment.class),
  SECTION2(2, CourseFragment.class),
  SECTION3(3, CourseFragment.class);

  private int position;
  private Class fragment;

  private MainNavigationItemsEnum(int position, Class fragment){
    this.position = position;
    this.fragment = fragment;
  }

  public int getPosition(){
    return this.position;
  }

  public Class getFragment(){
    return this.fragment;
  }

  public static MainNavigationItemsEnum getEnumByPosition(int position){
    if (position == HOME.getPosition()){
      return HOME;
    } else if (position == COURSES.getPosition()){
      return COURSES;
    } else if (position == SECTION2.getPosition()){
      return SECTION2;
    } else if (position == SECTION2.getPosition()){
      return SECTION3;
    } else {
      return null;
    }
  }
}
