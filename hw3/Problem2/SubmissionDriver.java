
public class SubmissionDriver {

	public static void main(String[] args){
		Submission sub = new Submission();
		TimeReport tReport = new TimeReport(sub);
		CorrectReport cReport = new CorrectReport(sub);
		sub.attach(tReport);
		sub.attach(cReport);
		
    	for(int i = 0; i < 10; i++){
    		sub.runTestCase();
    	}	
    	
    	int incorrect = 10 - cReport.getNumberCorrect() - tReport.getNumberOfTimeOutErrors();
    	System.out.println("Number of Correct: " + cReport.getNumberCorrect());
    	System.out.println("Number of Incorrect w/o Timeout: " +  incorrect);
    	System.out.println("Number of Timeout Errors: " + tReport.getNumberOfTimeOutErrors());
    }
	
}
