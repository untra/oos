/**
* Fish
*
* A single fish in the simulation
*/

import java.lang.Math;
import java.util.Observable;
import java.util.Random;

import sun.awt.SunHints.Value;

public class Fish extends Observable
{

  private static Random random = new Random();
  private static int numberOfFish = 0;
  public static final double INITIALHUNGER = 0.9;
  public static final double INITIALSIZE = 1.0;
  public static final double MINIMUMSTARVING = 0.2;
  public static final double MINIMUMHUNGERY = 0.7;
  public static final double MAXIMUMSIZENOTTOGETEATEN = 5.0;
  public static final double MINIMUMSIZETOEATOTHERFISH = 7.0;
  
  
  private double hunger;            // A value between 0 (hungry) and 1 (full)
  private double size;
  private double x;                 // Where the fish is
  private double y;
  private int id; 
  private FishStrategy fishStrategy;

  // Don't want to be able to directly query the fish for information, but do 
  // need to get information for logging or displaying on a GUI, etc.
//  private FishReport myFishReport = null;

  public Fish(double x, double y, FishReport report)
  {
    // A fish is born!
    hunger = INITIALHUNGER;
    size = INITIALSIZE;

    // Put it in the pond
    this.x = x;
    this.y = y;

    // And give it an id
    id = numberOfFish;
    numberOfFish++;

    // Who to report to?
    addObserver(report);
    //fishstretegy
    updateMoveStrategy();
    setChanged();
    notifyObservers(values());
  }

  private double[] values()
  {
	  double[] value = {hunger,size,x,y};
	  return value;
  }
  
  public double getSize()           
  {
    return size;
  } 

  public void age(double timePassed)
  {
    // Growth is based on how much time has passed and how much food
    // has been eaten
    double deltaSize = size * (1 + hunger * Math.exp(-size * timePassed));
    size = size + deltaSize;

    // If the fish grows a lot (relative to the size change), lots of food
    // has been consumed
    hunger = hunger * Math.exp(-deltaSize/size);

    setChanged();
    notifyObservers(values());  
  }

  public void move(Pond pond)
  {
	  updateMoveStrategy();
	  fishStrategy.move(this, pond, x, y);
  }

  // Swim towards a location
  public void swimTowards(double tx, double ty)
  {
    double distance = Math.sqrt((tx - x)*(tx - x) + (ty - y)*(ty - y));
    x = x + (tx/distance);
    y = y + (ty/distance);

    setChanged();
    notifyObservers(values());
  }


  // Swim away from a location
  public void swimAway(double tx, double ty)
  {
    double distance = Math.sqrt((tx - x)*(tx - x) + (ty - y)*(ty - y));
    x = x - (tx/distance);
    y = y - (ty/distance);

    setChanged();
    notifyObservers(values());
  }


  // Just swim around
  public void swimRandomly()
  {
    System.out.println("FISH #" + id + ": I'm swimming around!");

    x = x + random.nextDouble();
    y = y + random.nextDouble();

    setChanged();
    notifyObservers(values());
  }

  // Just let the world know I hid!
  public void hide()
  {
    System.out.println("FISH #" + id + ": I'm hiding!");
  }
  
  public void updateMoveStrategy()
  {
	// Fish movement involves either seeking out food, avoiding other
	    // fish, or being lazy and just swimming around if big enough

	    // If fish is starving, ignore possible preditors
	    if(hunger < MINIMUMSTARVING)              
	    {
	      if(size < MINIMUMSIZETOEATOTHERFISH)
	      {
	        // Smaller fish only eat plants
	        fishStrategy = new SwimToNearestPlantFishStrategy();
	      }
	      else
	      {
	        // Really big fish like to eat other fish
	        fishStrategy = new SwimToNearestSmallFishFishStrategy();
	      }
	    }
	    else 
	    { 
	      // Fish isn't starving, but is hungry
	      if (hunger < MINIMUMHUNGERY)
	      {
	        // A big enough fish won't worry about being eaten
	        if (size > MAXIMUMSIZENOTTOGETEATEN)
	        {
	          fishStrategy = new SwimRandomlyFishStrategy();
	        }
	        else
	        {
	          // Want to avoid the nearest big fish
	          fishStrategy = new AvoidBigFishFishStrategy();
	        }
	      }
	      else
	      {
	        // A really full fish will just hide and sleep
	        fishStrategy = new FullFishStrategy();
	      }
	    }
  }
}
