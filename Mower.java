import java.io.*;
import java.util.*;

public class Mower {

  private int x;
  private int y;
  private char direction;
  private List<String> steps;


  public Mower(int x, int y, char direction, List<String> steps) {
    this.x = x;
    this.y = y;
    this.direction = direction;
    this.steps = steps;
  }

  /* Getters */
  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public char getDirection() {
    return direction;
  }

  public List<String> getSteps() {
    return steps;
  }



  /* Setters */
  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public void setDirection(char direction) {
    this.direction = direction;
  }




}
