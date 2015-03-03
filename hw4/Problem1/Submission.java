/**
* Submission.java
*
* A basic dummy Submission object for use with the auto-grader
* Samuel Volin
* Cris Salazar
*/

import java.util.Random;

public class Submission
{
  private static Random rand = new Random();
  private int id;

  public Submission()
  {
    // Give this submission a unique(ish) id
    id = rand.nextInt(10000000);
  }
  
  public int getId()
  {
	  return id;
  }
}
