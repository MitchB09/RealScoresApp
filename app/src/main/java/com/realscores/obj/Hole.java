package com.realscores.obj;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by Mitch on 10/08/2017.
 */
public class Hole implements Serializable {

  private static final long serialVersionUID = 7862178050906377236L;

  @JsonProperty("holeId")
  private int hole_id;

  @JsonProperty("courseId")
  private int course_id;

  @JsonProperty("par")
  private int par;

  @JsonProperty("yards")
  private int yards;

  @JsonProperty("holeNumber")
  private int holeNumber;

  public int getHoleId() {
    return hole_id;
  }

  public void setHoleId(int hole_id) {
    this.hole_id = hole_id;
  }

  public int getCourseId() {
    return course_id;
  }

  public void setCourseId(int course_id) {
    this.course_id = course_id;
  }

  public int getPar() {
    return par;
  }

  public void setPar(int par) {
    this.par = par;
  }

  public int getYards() {
    return yards;
  }

  public void setYards(int yards) {
    this.yards = yards;
  }

  public int getHoleNumber() {
    return holeNumber;
  }

  public void setHoleNumber(int holeNumber) {
    this.holeNumber = holeNumber;
  }
}
