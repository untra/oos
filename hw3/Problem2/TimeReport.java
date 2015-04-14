

public class TimeReport extends Report {

	private static int numberOfTimeOutErrors;
	
	public TimeReport(Subject s){
		super(s);
		numberOfTimeOutErrors = 0;
	}
	
	
	public void update() {
		Submission sub = (Submission) subject;
			if(sub.wasTimeoutError()){
				System.out.println("Time-out Error Found");
				numberOfTimeOutErrors++;
			}		
		
	}
	
	public int getNumberOfTimeOutErrors(){
		return numberOfTimeOutErrors;
	}
}
