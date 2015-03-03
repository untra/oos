
public class CorrectReport {

	private static int numberCorrect;	
	
	public CorrectReport(){
		numberCorrect = 0;
	}
	
	public void update(boolean passed){
		if(passed)
			numberCorrect++;
	}
	
	public int getNumberCorrect(){
		return numberCorrect;
	}
	
}
