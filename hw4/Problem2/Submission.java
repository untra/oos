/**
* Submission.java
*
* A representation of a Submission
* Cris Salazar
* Samuel Volin
*/

import java.util.Random;

public class Submission extends Subject
{	
    private Random myRandom;
	private boolean lastErrorWasTimeout;
	private boolean lastTestPassed;

    // You may add attributes to this class if necessary
	
	public Submission()
	{
	    myRandom = new Random();
		lastErrorWasTimeout = false;
		
	}

    public void runTestCase()
	{
	    // For now, randomly pass or fail, possibly due to a timeout
		boolean passed = myRandom.nextBoolean();
		lastTestPassed = passed;
		if(!passed)
		{
		    lastErrorWasTimeout = myRandom.nextBoolean();
		}
		
		// You can add to the end of this method for reporting purposes
		announce();
	}
	
    public boolean wasTimeoutError()
	{
	    return lastErrorWasTimeout;
	}
    public boolean wasPassed()
	{
	    return lastTestPassed;
	}
}
