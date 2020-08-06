import java.io.*;
import java.util.*;

public class Test{

  public static void main(String[] args){

    try
    {
      File file = new File("inputfile.txt");
      Scanner buffer = new Scanner(file);
      String line = buffer.nextLine(); // read Lawn dimensions
      String[] lawn_dimensions = line.split(" ");
      List<Mower> mowers = new ArrayList<Mower>(); // Mowers List

      /* Create Lawn object with dimenions and mowers list */
      Lawn lawn = new Lawn(
        Integer.parseInt(lawn_dimensions[0]),
        Integer.parseInt(lawn_dimensions[1]),
        mowers
      );


      /* Parse the input file */
      String[] mower_pos_or; // to store mower's position and orientation
      String[] mower_steps;  // to store mower's steps
      while(buffer.hasNextLine()) { // loop until the EOF

        line = buffer.nextLine(); // read Mower's position & orientation
        mower_pos_or = line.split(" ");
        line = buffer.nextLine(); // read Mower steps
        mower_steps = line.split("");

        /* Create new mower with position, orientation and steps list*/
        Mower mower = new Mower(
          Integer.parseInt(mower_pos_or[0]),
          Integer.parseInt(mower_pos_or[1]),
          mower_pos_or[2].charAt(0),
          Arrays.asList(mower_steps)
        );

        /* Add the new mower to the mowers list of the Lawn */
        lawn.addMower(mower);
      }

      /* Execute the steps of the mowers */
      lawn.move();

      /* Print mowers position and orientation */
      lawn.PrintMowersPositions();

    }
    catch(Exception e)
    {
      e.getMessage();
    }


  }
}
