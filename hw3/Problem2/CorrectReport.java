
public class CorrectReport extends Report{

	private static int numberCorrect;	
	
	public CorrectReport(Subject s){
		super(s);
		numberCorrect = 0;
	}
	
	public void update(){
		Submission sub = (Submission) subject;
		if(sub.wasPassed())
			numberCorrect++;
	}
	
	public int getNumberCorrect(){
		return numberCorrect;
	}
	
}
