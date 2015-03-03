

public class TimeReport {

	private static int numberOfTimeOutErrors;
	
	public TimeReport(){
		numberOfTimeOutErrors = 0;
	}
	
	public void update(boolean passed, Submission sub) {
		if(!passed){
			if(sub.wasTimeoutError()){
				System.out.println("Time-out Error Found");
				numberOfTimeOutErrors++;
			}		
		}
		
	}
	
	public int getNumberOfTimeOutErrors(){
		return numberOfTimeOutErrors;
	}}
