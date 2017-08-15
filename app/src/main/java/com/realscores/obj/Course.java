package com.realscores.obj;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitch on 10/08/2017.
 */
public class Course implements Serializable{

  private static final long serialVersionUID = -2366507745359730865L;

  @JsonProperty("courseId")
  private int course_id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("holes")
  private List<Hole> holes = new ArrayList<Hole>();

  public int getCourseId() {
    return course_id;
  }

  public void setCourseId(int course_id) {
    this.course_id = course_id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Hole> getHoles() {
    return holes;
  }

  public void setHoles(List<Hole> holes) {
    this.holes = holes;
  }
}
