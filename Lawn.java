import java.io.*;
import java.util.*;

public class Lawn {

  private int height;
  private int width;
  private List<Mower> mowers;

  public Lawn(int height, int width, List<Mower> mowers) {
    this.height = height;
    this.width = width;
    this.mowers = mowers;
  }


  /* Getters */
  public int getHeight() {
    return height;
  }

  public int getWidth() {
    return width;
  }

  public List<Mower> getMowers() {
    return mowers;
  }


  /* Setters */
  public void addMower(Mower mower){
    this.mowers.add(mower);
  }


  /* Execute all steps to move the Mowers */
  public void move() {

    String movement = "";
    char direction;
    int mow_x;
    int mow_y;

    /* Loop to get all mowers from the mowers list*/
    for ( int i = 0 ; i < this.mowers.size() ; i++ ) {

      /* Loop to get all steps of the current mower */
      List<String> steps = this.mowers.get(i).getSteps();
      for ( int k = 0 ; k < steps.size() ; k++ ) {

        movement = steps.get(k); // get step k
        direction = this.mowers.get(i).getDirection(); // get direction before step k
        mow_x = this.mowers.get(i).getX(); // get position x before step k
        mow_y = this.mowers.get(i).getY(); // get position y before step k

        if ( movement.equals("L") ) {
            if ( direction == 'N' ) {
              this.mowers.get(i).setDirection('W');
            }
            else if ( direction == 'S' ) {
              this.mowers.get(i).setDirection('E');
            }
            else if ( direction == 'E' ) {
              this.mowers.get(i).setDirection('N');
            }
            else if ( direction == 'W' ) {
              this.mowers.get(i).setDirection('S');
            }
        }

        else if ( movement.equals("R") ) {
            if ( direction == 'N' ) {
              this.mowers.get(i).setDirection('E');
            }
            else if ( direction == 'S' ) {
              this.mowers.get(i).setDirection('W');
            }
            else if ( direction == 'E' ) {
              this.mowers.get(i).setDirection('S');
            }
            else if ( direction == 'W' ) {
              this.mowers.get(i).setDirection('N');
            }
        }

        else if ( movement.equals("F") ) {
            if ( this.mowers.get(i).getDirection() == 'N' ) {
              if ( mow_y+1 <= this.height ) {
                this.mowers.get(i).setY(mow_y+1);
              }
            }
            else if ( this.mowers.get(i).getDirection() == 'S' ) {
              if ( mow_y-1 >= 0 ) {
                this.mowers.get(i).setY(mow_y-1);
              }
            }
            else if ( this.mowers.get(i).getDirection() == 'E' ) {
              if ( mow_x+1 <= this.width ) {
                this.mowers.get(i).setX(mow_x+1);
              }
            }
            else if ( this.mowers.get(i).getDirection() == 'W' ) {
              if ( mow_x-1 >= 0 ) {
                this.mowers.get(i).setX(mow_x-1);
              }
            }
        }

      }
    }
  }


  public void PrintMowersPositions() {

    for ( int i = 0 ; i < this.mowers.size() ; i++ ) {
      System.out.println(this.mowers.get(i).getX() + " " + this.mowers.get(i).getY() + " " + this.mowers.get(i).getDirection());
    }
  }

}
