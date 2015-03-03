
public class SubmissionDriver {

	public static void main(String[] args){
		Submission sub = new Submission();
    	for(int i = 0; i < 10; i++){
    		sub.runTestCase();
    	}	
    	
    	int incorrect = 10 - sub.getCReport().getNumberCorrect() - sub.getTReport().getNumberOfTimeOutErrors();
    	System.out.println("Number of Correct: " + sub.getCReport().getNumberCorrect());
    	System.out.println("Number of Incorrect w/o Timeout: " +  incorrect);
    	System.out.println("Number of Timeout Errors: " + sub.getTReport().getNumberOfTimeOutErrors());
    }
	
}
