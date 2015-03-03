/**
* Submission.java
*
* A representation of a Submission
* Cris Salazar
* Samuel Volin
*/

import java.util.Random;

public class Submission
{	
    private Random myRandom;
	private boolean lastErrorWasTimeout;

    // You may add attributes to this class if necessary
	
	private TimeReport tReport;
	private CorrectReport cReport;

	public Submission()
	{
	    myRandom = new Random();
		lastErrorWasTimeout = false;
		
		tReport = new TimeReport();
		cReport = new CorrectReport();
	}


    public void runTestCase()
	{
	    // For now, randomly pass or fail, possibly due to a timeout
		boolean passed = myRandom.nextBoolean();
		if(!passed)
		{
		    lastErrorWasTimeout = myRandom.nextBoolean();
		}
		
		// You can add to the end of this method for reporting purposes
		tReport.update(passed, this);
		cReport.update(passed);
	}
	
    public boolean wasTimeoutError()
	{
	    return lastErrorWasTimeout;
	}
    
    public TimeReport getTReport(){
    	return tReport;
    }
    
    public CorrectReport getCReport(){
    	return cReport;
    }
}
